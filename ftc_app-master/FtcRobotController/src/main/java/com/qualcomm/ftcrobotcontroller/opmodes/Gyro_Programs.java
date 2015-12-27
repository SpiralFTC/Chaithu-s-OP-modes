package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;


public class Gyro_Programs extends OpMode {
    public static DcMotor leftMotor;
    public static DcMotor rightMotor;
    public static GyroSensor gyroSensor;
    public static int a = 1;
    public static int caseNumber = 1;
   // public static final double treadLength = 90.01125;
    public static final double oneRevolutionTreadLength = 14.8370192308;


    private double startTime;
    private boolean runTimerStarted;

    @Override
    public void init() {
        runTimerStarted = false;
    }


    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        //super.stop();
    }

    /*public void gyroStraight(int b, double c, double x) {
        double z;
        double y;


        boolean head = false;

        if (gyroSensor.getHeading() > 4 && gyroSensor.getHeading() < 356) {
            head = true;
        }

        if (!head) {

            leftMotor.setPower(0.6);
            rightMotor.setPower(0.6);
        }
        if (gyroSensor.getHeading() < b && gyroSensor.getHeading() < 180) {
            int temp = gyroSensor.getHeading();
            y = (c + (x * (b - temp)));
            z = (c - (x * (b - temp)));
            Range.clip(y, -1, 1);
            Range.clip(z, -1, 1);
            drive(y, z);
        } else if (gyroSensor.getHeading() > b && gyroSensor.getHeading() > 180) {
            int temp = gyroSensor.getHeading();
            y = (c - (x * (temp - b)));
            z = (c + (x * (temp - b)));
            Range.clip(y, -1, 1);
            Range.clip(z, -1, 1);
            drive(y, z);
        } else if ((gyroSensor.getHeading()) < ((b + 360))) {
            int temp = gyroSensor.getHeading();
            y = (c + (x * (b - temp)));
            z = (c - (x * (b - temp)));
            Range.clip(y, -1, 1);
            Range.clip(z, -1, 1);
            drive(y, z);
        } else if (gyroSensor.getHeading() + 360 > b) {
            int temp = gyroSensor.getHeading();
            y = (c - (x * (temp - b)));
            z = (c + (x * (temp - b)));
            Range.clip(y, -1, 1);
            Range.clip(z, -1, 1);
            drive(y, z);
        } else {
            drive(0.8, 0.8);
        }
    }
*/

    public static void drive(double x, double y) {
        rightMotor.setPower(x);
        leftMotor.setPower(y);
    }

    public boolean driveForwardForTime(double power, double targetTime) {
        drive(power, power);
        return targetTimeReached(targetTime);
    }


    public boolean targetTimeReached(double targetTime) {

        if (!runTimerStarted) {
            runTimerStarted = true;
            startTime = getRuntime();
            return false;
        } else {
            boolean result = (getRuntime() - startTime) >= targetTime;
            if (result) {
                runTimerStarted = false;

            }
            return result;
        }


    }

    public boolean driveBackwardForTime(double power, double targetTime) {
        drive(power, power);
        return targetTimeReached(targetTime);
    }

    public boolean turnRightForTime(double power, double targetTime) {
        drive(power, power);
        return targetTimeReached(targetTime);
    }

    public boolean turnLeftForTime(double power, double targetTime) {
        drive(power, power);
        return targetTimeReached(targetTime);
    }
}

