package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileTypeSizeCounterSimple {
    public static void main(String[] args) {
        String inputFilePath = "D:\\sample2025.txt";
        String outputFilePath = "D:\\fileTypeSummary.txt"; // 输出在当前运行目录
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        Map<String, Long> fileTypeSummaries = new HashMap<>();

        // 主要的 try-catch 块，包含所有文件读写操作
        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line;
            // === 读取和处理输入文件 ===
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    continue;
                }
                String sizeStr = parts[parts.length - 2];
                String fileName = parts[parts.length - 1];
                long sizeKb;

                try {
                    sizeKb = Long.parseLong(sizeStr.replace(",", ""));
                } catch (NumberFormatException e) {
                    continue;
                }

                String extension = "未知类型";
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                    extension = fileName.substring(dotIndex + 1).toLowerCase();
                }

                fileTypeSummaries.put(extension, fileTypeSummaries.getOrDefault(extension, 0L) + sizeKb);
            }

            // === 将统计结果写入到输出文件 ===
            bufferedWriter.write("文件类型统计结果 (总大小 KB):");
            bufferedWriter.newLine();

            if (fileTypeSummaries.isEmpty()) {
                bufferedWriter.write("没有处理任何文件数据。");
                bufferedWriter.newLine();
            } else {
                // 注意：这里遍历的是已经累积好的 fileTypeSummaries
                for (Map.Entry<String, Long> entry : fileTypeSummaries.entrySet()) {
                    String summaryLine = "- 类型: " + entry.getKey().toUpperCase() +
                            ", 总大小: " + entry.getValue() + " KB";
                    bufferedWriter.write(summaryLine);
                    bufferedWriter.newLine();
                }
            }
            System.out.println("文件统计处理完成！结果已写入到: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("处理文件时发生错误: " + e.getMessage());
        }
        // === 在控制台打印统计结果（在文件操作的try-catch块之后） ===
        System.out.println("\n========== 控制台统计结果 ==========");
        if (fileTypeSummaries.isEmpty()) {
            boolean inputErrorOccurred = false;
            if (!inputFile.exists()) inputErrorOccurred = true; // 简单检查，实际错误可能更复杂

            if(inputErrorOccurred && fileTypeSummaries.isEmpty()){ // 如果输入文件就有问题且map为空
                System.out.println("由于输入文件问题，未能统计到数据。");
            } else if (fileTypeSummaries.isEmpty()){ // 如果map就是空的（例如输入文件内容为空或不符合格式）
                System.out.println("没有统计到任何有效的文件数据。");
            }

        } else {
            for (Map.Entry<String, Long> entry : fileTypeSummaries.entrySet()) {
                System.out.println("- 类型: " + entry.getKey().toUpperCase() +
                        ", 总大小: " + entry.getValue() + " KB");
            }
        }
        System.out.println("===================================");
        System.out.println("程序运行结束。");
    }
}
