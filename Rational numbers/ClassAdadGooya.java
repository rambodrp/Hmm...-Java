//package Tamrin;

import java.util.Scanner;

public class ClassAdadGooya {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int s, m, tempStorage1, tempStorage2, sadeSaz = 1;
            int x = input.nextInt();
            int y = input.nextInt();
            char operator = input.next().charAt(0);
            int a = input.nextInt();
            int b = input.nextInt();
            // --------------------------------------------------
            if (operator == '+') {
                tempStorage1 = x * b;
                tempStorage2 = a * y;
                s = tempStorage1 + tempStorage2;
                m = y * b;
                if (s > 0) {
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (s < 0 && m < 0) {
                    s = s * -1;
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (m < 0) {
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    m = m * -1;
                    System.out.println(s + "/" + m);
                } else if (s < 0) {
                    s = s * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    s = s * -1;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                }
            }
            if (operator == '-') {
                tempStorage1 = x * b;
                tempStorage2 = a * y;
                s = tempStorage1 - tempStorage2;
                m = b * y;
                if (s > 0) {
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (s < 0 && m < 0) {
                    s = s * -1;
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (m < 0) {
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    m = m * -1;
                    System.out.println(s + "/" + m);
                } else if (s < 0) {
                    s = s * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    s = s * -1;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                }
            }
            if (operator == '*') {
                s = x * a;
                m = y * b;
                if (s == 0) {
                    System.out.println(0 + "/" + 1);
                } else if (s > 0) {
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (s < 0 && m < 0) {
                    s = s * -1;
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (m < 0) {
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    m = m * -1;
                    System.out.println(s + "/" + m);
                } else if (s < 0) {
                    s = s * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    s = s * -1;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                }
            }
            if (operator == '/') {
                s = x * b;
                m = a * y;
                if (s > 0) {
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (s < 0 && m < 0) {
                    s = s * -1;
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                } else if (m < 0) {
                    m = m * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    m = m / sadeSaz;
                    m = m * -1;
                    System.out.println(s + "/" + m);
                } else if (s < 0) {
                    s = s * -1;
                    for (int i = 1; i <= s && i <= m; i++) {
                        if (s % i == 0 && m % i == 0) {
                            sadeSaz = i;
                        }
                    }
                    s = s / sadeSaz;
                    s = s * -1;
                    m = m / sadeSaz;
                    System.out.println(s + "/" + m);
                }
            }
        }
    }
}
