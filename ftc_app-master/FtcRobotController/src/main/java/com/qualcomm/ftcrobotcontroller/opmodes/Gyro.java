package com.qualcomm.ftcrobotcontroller.opmodes;




public class Gyro extends Gyro_Programs {


    public static void gyroTurn(int d) {
        boolean value = false;

        int b = d - 2;
        int c = d + 2;

        if (d == 0) {

            b = 0;
            c = 2;
        }

        if (gyroSensor.getHeading() >= b && gyroSensor.getHeading() <= c ) {
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
    public static void sleepMove() {

        int x = 0;
        int y = 2;
        boolean head = false;

        if (gyroSensor.getHeading() > 4 && gyroSensor.getHeading() < 356){
            head = true;
        }

        if (!head) {

            leftMotor.setPower(0.6);
            rightMotor.setPower(0.6);
        }





      /*  switch (caseNumber) {
            case 1:

                leftMotor.setPower(0.6);
                rightMotor.setPower(0.6);




            case 2:
                caseNumber = 1;


               if (gyroSensor.getHeading() > 4) {
                    rightMotor.setPower(-0.65);
                    leftMotor.setPower(0.65);
                    break;


                } else if (gyroSensor.getHeading() < 358) {
                    rightMotor.setPower(0.65);
                    leftMotor.setPower(-0.65);
                    break;


                }
*/

                }


    public static void moveCentimeters(double centimeters)  {
        double revolutionmove =  centimeters / oneRevolutiontreadLength;
        boolean checkmove = false;
        if(!checkmove){

            rightMotor.setPower(0.6);
            leftMotor.setPower(0.6);
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

