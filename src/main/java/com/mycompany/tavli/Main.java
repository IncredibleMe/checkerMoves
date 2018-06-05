package com.mycompany.tavli;

import java.util.Arrays;

public class Main {

    private static int[] board = {2, 0, 0, 0, 0, -5, 0, -3, 0, 0, 0, 5, -5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, -2, 0, 0, 0, 0};

    public static void main(String[] args) {
        printTable();
        int d1 = 6;
        int d2 = 6;

        move(d1, d2);

        if (d1 == d2) {
            move(d1, d2);
        }
    }

    static boolean mazema() {
        int c = 0;
        for (int i = 18; i < 24; i++) {
            if (board[i] > 0) {
                c += board[i];
            }
        }
        if (c == 15) {
            return true;
        }

        return false;
    }

    static boolean ektos() {
        if (board[26] > 0) {
            return true;
        }
        return false;
    }

    static void move(int d1, int d2) {
        int[] board2;
        board2 = new int[28];
        board2 = Arrays.copyOf(board, 28);
        int[] board3;
        board3 = new int[28];
        board3 = Arrays.copyOf(board, 28);
        if (ektos()) {
            if (board[d1 - 1] >= 0) {
                board[d1 - 1]++;
                board[26]--;
                board3 = Arrays.copyOf(board, 28);
                for (int j = 0; j < 24; j++) {
                    if (board[j] > 0) {
                        if (board[j + d2] >= 0) {
                            if (mazema()) {
                                if ((j + d2) > 23) {
                                    board[24]++;
                                    board[j]--;
                                    printTable();
                                    board = Arrays.copyOf(board3, 28);
                                } else {
                                    board[j + d2]++;
                                    board[j]--;
                                    printTable();
                                    board = Arrays.copyOf(board3, 28);
                                }
                            } else if ((j + d2) <= 23) {
                                board[j]--;
                                board[j + d2]++;
                                printTable();
                                board = Arrays.copyOf(board3, 28);
                            }
                        }
                    }

                }
            }
            board = Arrays.copyOf(board2, 28);
        }
        if (ektos()) {
            if (board[d2 - 1] >= 0) {
                board[d2 - 1]++;
                board[26]--;
                board3 = Arrays.copyOf(board, 28);
                for (int j = 0; j < 24; j++) {
                    if (board[j] > 0) {
                        if (board[j + d1] >= 0) {
                            if (mazema()) {
                                if ((j + d1) > 23) {
                                    board[24]++;
                                    board[j]--;
                                    printTable();
                                    board = Arrays.copyOf(board3, 28);
                                } else {
                                    board[j + d1]++;
                                    board[j]--;
                                    printTable();
                                    board = Arrays.copyOf(board3, 28);
                                }
                            } else if ((j + d1) <= 23) {
                                board[j]--;
                                board[j + d1]++;
                                printTable();
                                board = Arrays.copyOf(board3, 28);
                            }
                        }
                    }

                }
            }
            board = Arrays.copyOf(board2, 28);

        } else {

            for (int i = 0; i < 24; i++) {

                if (board[i] > 0) {

                    if (board[i + d1] >= 0 && i + d1 < 24) {
                        board[i]--;
                        board[i + d1]++;
                        board3 = Arrays.copyOf(board, 28);

                        for (int j = 0; j < 24; j++) {
                            if (board[j] > 0) {

                                if (mazema()) {
                                    if ((j + d2) > 23) {
                                        board[24]++;
                                        board[j]--;
                                        printTable();
                                        board = Arrays.copyOf(board3, 28);
                                    } else {
                                        
                                        board[j + d2]++;
                                        board[j]--;
                                        printTable();
                                        board = Arrays.copyOf(board3, 28);
                                    }
                                } else if ((j + d2) <= 23) {
                                    if (board[j + d2] >= 0) {
                                        board[j]--;
                                        board[j + d2]++;
                                        printTable();
                                        board = Arrays.copyOf(board3, 28);
                                    }
                                }
                            }

                        }
                    }
                    board = Arrays.copyOf(board2, 28);
                }
            }
        }
    }

    static void printTable() {
        int[] board2;
        board2 = new int[28];
        board2 = Arrays.copyOf(board, 28);
        int bl = -30, wh = 0;
        for (int i = 11; i >= 0; i--) {
            if (board2[i] > wh) {
                wh = board2[i];
            } else if (board2[i] < bl) {
                bl = board2[i];
            }
        }

        for (int p = 0; p < Integer.max(bl, wh); p++) {
            for (int i = 11; i >= 0; i--) {
                if (board2[i] > 0) {
                    System.out.print("O");
                    board2[i]--;
                    System.out.print(" ");
                } else if (board2[i] < 0) {
                    System.out.print("*");
                    board2[i]++;
                    System.out.print(" ");
                } else {
                    System.out.print("_ ");
                }

            }
            System.out.println("");
        }
        System.out.println("");

        bl = -30;
        wh = 0;

        for (int i = 12; i <= 23; i++) {
            if (board2[i] > wh) {
                wh = board2[i];
            } else if (board2[i] < bl) {
                bl = board2[i];
            }
        }

        int h = Integer.max(bl, wh);
        for (int p = 0; p < Integer.max(bl, wh); p++) {
            for (int i = 12; i <= 23; i++) {

                if (board2[i] > 0) {
                    if (Integer.max(bl, wh) - p > board2[i]) {
                        System.out.print("_ ");
                    } else {
                        System.out.print("O");
                        board2[i]--;
                        System.out.print(" ");
                    }
                } else if (board2[i] < 0) {
                    if (Integer.max(bl, wh) - p > Math.abs(board2[i])) {
                        System.out.print("_ ");
                    } else {
                        System.out.print("*");
                        board2[i]++;
                        System.out.print(" ");
                    }
                } else {
                    System.out.print("_ ");
                }

            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("=======================================");
        System.out.println("");
    }

}
