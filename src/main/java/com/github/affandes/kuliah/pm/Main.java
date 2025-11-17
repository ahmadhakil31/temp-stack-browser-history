package com.github.affandes.kuliah.pm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PROGRAM PEMOTONG FILE TEKS (QUEUE) ===");
        System.out.print("Masukkan nama file (misalnya: input.txt): ");
        String filename = scanner.nextLine();

        System.out.print("Masukkan jumlah bagian: ");
        int parts = scanner.nextInt();

        Queue<String> linesQueue = new LinkedList<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                linesQueue.add(line);
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        System.out.println("\nTotal baris terbaca: " + linesQueue.size());
        System.out.println("Memotong file menjadi " + parts + " bagian...\n");

        
        int totalLines = linesQueue.size();
        int linesPerPart = (int) Math.ceil((double) totalLines / parts);

        
        for (int i = 1; i <= parts; i++) {
            System.out.println("=== Bagian " + i + " ===");

            int count = 0;

            while (count < linesPerPart && !linesQueue.isEmpty()) {
                System.out.println(linesQueue.poll());
                count++;
            }

            System.out.println();
        }

        System.out.println("Pemotongan file selesai.");
    }
}
