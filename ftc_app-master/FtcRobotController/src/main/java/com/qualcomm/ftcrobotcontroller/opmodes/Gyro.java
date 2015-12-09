package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;


public class Gyro extends Gyro_Programs {


    public void gyroTurn(int b, int c) {
        boolean value = false;
        if (gyroSensor.getHeading() >= b && gyroSensor.getHeading() <= c) {
            value = true;
        }

        if (!value) {
            a++;
        }

        switch (a) {
            case 1:

                leftMotor.setPower(0);
                rightMotor.setPower(0);

                break;


            case 2:
                a = 1;
                if (gyroSensor.getHeading() < b) {
                    rightMotor.setPower(-0.7);
                    leftMotor.setPower(0.7);
                    break;


                } else if (gyroSensor.getHeading() > c) {
                    rightMotor.setPower(0.7);
                    leftMotor.setPower(-0.7);
                    break;


                }


        }

    }


    public static void sleep(long sleepTime) {
        long wakeupTime = System.currentTimeMillis() + sleepTime;

        while (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                sleepTime = wakeupTime - System.currentTimeMillis();
            }
        }

    }

    //sleep
    public static void sleepMove(long sleepTime, int x, int y) {

        boolean value = false;
        if (gyroSensor.getHeading() >= x && gyroSensor.getHeading() <= y) {
            value = true;
        }

        if (!value) {
            lol++;
        }

        switch (lol) {
            case 1:

                leftMotor.setPower(0.7);
                rightMotor.setPower(0.7);

                break;


            case 2:
                lol = 1;
                if (gyroSensor.getHeading() < x) {
                    rightMotor.setPower(-0.7);
                    leftMotor.setPower(0.7);
                    break;


                } else if (gyroSensor.getHeading() > y) {
                    rightMotor.setPower(0.7);
                    leftMotor.setPower(-0.7);
                    break;


                }


        }

    }
}



        /*long wakeupTime = System.currentTimeMillis() + sleepTime;

            leftMotor.setPower(c);
            rightMotor.setPower(c);
            if (gyroSensor.getHeading() < b && gyroSensor.getHeading() < 180) {
                int temp = gyroSensor.getHeading();
                double C = (c + (0.01 * (b - temp)));
                double D = (c - (0.01 * (b - temp)));
                //Range.clip(C, -1, 1);
                //Range.clip(D,-1,1);
                if (C > 1 || C < -1) {
                    if (C > 1) {
                        C = 1;
                    }
                    if (C < -1) {
                        C = -1;
                    }
                }

                if (D > 1 || D < -1) {
                    if (D > 1) {
                        D = 1;
                    }
                    if (D < -1) {
                        D = -1;
                    }
                }

                leftMotor.setPower(C);
                rightMotor.setPower(D);
            }
            if (gyroSensor.getHeading() > b && gyroSensor.getHeading() > 1) {
                int temp = gyroSensor.getHeading();
                double C = (c - (0.01 * (temp - b)));
                double D = (c + (0.01 * (temp - b)));
                if (C > 1 || C < -1) {
                    if (C > 1) {
                        C = 1;
                    }
                    if (C < -1) {
                        C = -1;
                    }
                }

                if (D > 1 || D < -1) {
                    if (D > 1) {
                        D = 1;
                    }
                    if (D < -1) {
                        D = -1;
                    }
                }
                leftMotor.setPower(C);
                rightMotor.setPower(D);
            }
            if ((gyroSensor.getHeading()) < ((b + 360))) {
                int temp = gyroSensor.getHeading();
                double C = (c + (0.01 * (b - temp)));
                double D = (c - (0.01 * (b - temp)));
                if (C > 1 || C < -1) {
                    if (C > 1) {
                        C = 1;
                    }
                    if (C < -1) {
                        C = -1;
                    }
                }

                if (D > 1 || D < -1) {
                    if (D > 1) {
                        D = 1;
                    }
                    if (D < -1) {
                        D = -1;
                    }
                }
                leftMotor.setPower(C);
                rightMotor.setPower(D);
            }
            if (gyroSensor.getHeading() + 360 > b) {
                int temp = gyroSensor.getHeading();
                double C = (c - (0.01 * (temp - b)));
                double D = (c + (0.01 * (temp - b)));
                if (C > 1 || C < -1) {
                    if (C > 1) {
                        C = 1;
                    }
                    if (C < -1) {
                        C = -1;
                    }
                }

                if (D > 1 || D < -1) {
                    if (D > 1) {
                        D = 1;
                    }
                    if (D < -1) {
                        D = -1;
                    }
                }
                leftMotor.setPower(C);
                rightMotor.setPower(D);
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                sleepTime = wakeupTime - System.currentTimeMillis();
            }
        }
    }   //sleep


}*/

