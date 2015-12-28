package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;


public class Gyro extends Gyro_Programs {




    public  void gyroTurn(int d,double power) {
        leftMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        boolean value = false;

        int b = d - 5;
        int c = d + 5;

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
                    rightMotor.setPower(-power);
                    leftMotor.setPower(power);
                    break;


                } else if (gyroSensor.getHeading() > c) {
                    rightMotor.setPower(power);
                    leftMotor.setPower(-power);
                    break;


                }


        }
        leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

    }



   /* public static void sleep(long sleepTime) {
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
    public static boolean move_inches(double move_parameter) {
        //parameter should be in inches
        double distance = move_parameter;
        int heading = 0;
        double rate = 6;

        double time = ((distance / rate) * 1000);
        boolean timercheck = false;
        int timer = 0;
        while (!timercheck) {
            if (timer == time) {
                timercheck = true;
            }
            if (gyroSensor.getHeading() > (heading + 2) && gyroSensor.getHeading() < 358) {
                return false;
            }
            leftMotor.setPower(0.6);
            leftMotor.setPower(0.6);
            timer++;
        }
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        return true;

    }

    public static void sleepMove(long sleepTime, int x, int y) {


        if ((gyroSensor.getHeading() > x) && (gyroSensor.getHeading() < y)) {
            leftMotor.setPower(1);
            rightMotor.setPower(1);

        } else {
            leftMotor.setPower(.5);
            rightMotor.setPower(-.5);

        }
    }
    */

    /**
     * Move the robot for the given distance
     *
     * @param distence
     * @param diametre
     */
    public void moveCentimetresTyre(double distence, double diametre, double power) {
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        double circumference = diametre * Math.PI;

        double revolutions = distence / circumference;
        rightMotor.setTargetPosition((int) (revolutions * 1072));
        leftMotor.setTargetPosition((int) (revolutions * 1072));
        rightMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        //boolean checkmove = false;


        rightMotor.setPower(power);
        leftMotor.setPower(power);
    }

        public void moveCentimetres(double distence, double power) {
            leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            double revolutionmove = distence / oneRevolutiontreadLength;
            rightMotor.setTargetPosition((int) (revolutionmove * 1072));
            leftMotor.setTargetPosition((int) (revolutionmove * 1072));
            rightMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
            leftMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

            //boolean checkmove = false;


            rightMotor.setPower(power);
            leftMotor.setPower(power);
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
}