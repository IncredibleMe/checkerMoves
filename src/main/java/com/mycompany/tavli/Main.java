package com.mycompany.tavli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static int[] board = {2, 0, 0, 0, 0, -5, 0, -3, 0, 0, 0, 5, -5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, -2, 0, 0, 0, 0};
    //private static int[] board = {0, 0, 0, 0, 0, -5, 0, -3, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 3, 5, 5, 2, -2, 0, 0, 0, 0};
    static int[] temp;

    public static void main(String[] args) {
        printTable("");
        int d1 = 4;
        int d2 = 4;

        temp = new int[28];
        if (d1 == d2) {
            move(d1, d2, 1, board, "");
        } else {
            move(d1, d2, 0, board, "");
        }

    }

    static boolean mazema() {
        int c = 0;
        for (int i = 18; i < 25; i++) {
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

    static String move = "";

    static void move(int d1, int d2, int x, int boardd[], String move2) {

        board = Arrays.copyOf(boardd, 28);
        String move ="";
        move += move2;

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
                move2 = "" + 0 + "->" + (d1) + " and ";
                board3 = Arrays.copyOf(board, 28);
                for (int j = 0; j < 24; j++) {
                    if (board[j] > 0) {
                        if (board[j + d2] >= 0) {
                            if (mazema()) {
                                if ((j + d2) > 23) {
                                    board[24]++;
                                    board[j]--;
                                    move = move2 + j + " -> " + "24";
                                    if (x == 0) {
                                        printTable(move);
                                    }
                                    temp = Arrays.copyOf(board, 28);
                                    board = Arrays.copyOf(board3, 28);
                                } else {
                                    board[j + d2]++;
                                    board[j]--;
                                    move = move2 + j + " -> " + (j + d2);
                                    if (x == 0) {
                                        printTable(move);
                                    }
                                    temp = Arrays.copyOf(board, 28);
                                    board = Arrays.copyOf(board3, 28);
                                }
                            } else if ((j + d2) <= 23) {
                                board[j]--;
                                board[j + d2]++;
                                move = move2 + j + " -> " + (j + d2);
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
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
                move2 = "" + 0 + "->" + (d2) + " and ";
                board3 = Arrays.copyOf(board, 28);
                for (int j = 0; j < 24; j++) {
                    if (board[j] > 0) {
                        if (board[j + d1] >= 0) {
                            if (mazema()) {
                                if ((j + d1) > 23) {
                                    board[24]++;
                                    board[j]--;
                                    move = move2 + j + " -> " + "24";
                                    if (x == 0) {
                                        printTable(move);
                                    }
                                    temp = Arrays.copyOf(board, 28);
                                    board = Arrays.copyOf(board3, 28);
                                } else {
                                    board[j + d1]++;
                                    board[j]--;
                                    move = move2 + j + " -> " + (j + d1);
                                    if (x == 0) {
                                        printTable(move);
                                    }
                                    temp = Arrays.copyOf(board, 28);
                                    board = Arrays.copyOf(board3, 28);
                                }
                            } else if ((j + d1) <= 23) {
                                board[j]--;
                                board[j + d1]++;
                                move = move2 + j + " -> " + (j + d1);
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
                                board = Arrays.copyOf(board3, 28);
                            }
                        }
                    }

                }
            }
            board = Arrays.copyOf(board2, 28);

        }
        if (mazema()) {
            for (int i = 0; i < 24; i++) {

                if ((i + d1) > 23) {
                    board[24]++;
                    board[i]--;
                    move += move2 + i + " -> " + "24";
                    //printTable(move);
                    board = Arrays.copyOf(board3, 28);
                    for (int j = 0; j < 24; j++) {
                        if (board[j] > 0) {

                            if ((j + d2) > 23) {
                                board[24]++;
                                board[j]--;
                                move = move2 + j + " -> " + "24";
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
                                board = Arrays.copyOf(board3, 28);
                            } else {

                                board[j + d2]++;
                                board[j]--;
                                move = move2 + j + " -> " + (j + d2);
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
                                board = Arrays.copyOf(board3, 28);
                            }

                        }

                    }

                } else if ((i + d2) > 23) {
                    board[24]++;
                    board[i]--;
                    move += move2 + i + " -> " + "24";
                    //printTable(move);
                    board = Arrays.copyOf(board3, 28);
                    d2 = d1;
                    for (int j = 0; j < 24; j++) {
                        if (board[j] > 0) {

                            if ((j + d2) > 23) {
                                board[24]++;
                                board[j]--;
                                move = move2 + j + " -> " + "24";
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
                                board = Arrays.copyOf(board3, 28);
                            } else {

                                board[j + d2]++;
                                board[j]--;
                                move = move2 + j + " -> " + (j + d2);
                                if (x == 0) {
                                    printTable(move);
                                }
                                temp = Arrays.copyOf(board, 28);
                                board = Arrays.copyOf(board3, 28);
                            }

                        }

                    }

                }

            }
        } else {

            for (int i = 0; i < 24; i++) {

                if (board[i] > 0) {

                    if (i + d1 < 24) {
                        if (board[i + d1] >= 0) {
                            board[i]--;
                            board[i + d1]++;
                           move2 =  " " + i + "->" + (i + d1) + " and ";
                            board3 = Arrays.copyOf(board, 28);

                            for (int j = 0; j < 24; j++) {
                                if (board[j] > 0) {

                                    if (mazema()) {
                                        if ((j + d2) > 23) {
                                            board[24]++;
                                            board[j]--;
                                            move = move2 + j + " -> " + "24 ";
                                            if (x == 0) {
                                                printTable(move);
                                            }
                                            temp = Arrays.copyOf(board, 28);
                                            board = Arrays.copyOf(board3, 28);
                                        } else {

                                            board[j + d2]++;
                                            board[j]--;
                                            move = move2 + j + " -> " + (j + d2) + " ";
                                            if (x == 0) {
                                                printTable(move);
                                            }
                                            temp = Arrays.copyOf(board, 28);
                                            board = Arrays.copyOf(board3, 28);
                                        }
                                    } else if ((j + d2) <= 23) {
                                        if (board[j + d2] >= 0) {
                                            board[j]--;
                                            board[j + d2]++;
                                            move = move2 + j + " -> " + (j + d2) + " ";
                                            if (x == 0) {
                                                printTable(move);
                                            }
                                            temp = Arrays.copyOf(board, 28);
                                            board = Arrays.copyOf(board3, 28);
                                        }
                                    }
                                }

                            }
                        }
                        board = Arrays.copyOf(board2, 28);
                    }
                    board = Arrays.copyOf(board2, 28);
                }
            }
        }
        if (x == 0) {
            return;
        }

        if (d1 == d2) {
            move(d1, d2, 0, temp, move);
        }
    }

    static void printTable(String move) {
        System.out.println(move);
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
//        try {
//            insertToDB(move);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Main.move = "";
    }

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static void insertToDB(String move) throws ClassNotFoundException, SQLException {
        String dbCon = "jdbc:mysql://195.251.162.129:3306/giannakaras";

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        Connection conn = DriverManager.getConnection(dbCon, "giannakaras", "giannakaras");
        System.out.println("Connected database successfully...");

        Statement stmt = null;
        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();

        String sql = "INSERT INTO nextmove VALUES (";
        for (int i = 0; i < 27; i++) {
            sql += board[i] + ", ";

        }
        sql += board[27] + ", '" + move + "');";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

}
