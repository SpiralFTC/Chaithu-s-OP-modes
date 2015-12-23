package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;


public class Autonomous extends Gyro {
    Servo RightServo;
    Servo LeftServo;


    double ServoPosition = 0.7;

    @Override
    public void init() {
       // RightServo = hardwareMap.servo.get("arm");
       // LeftServo = hardwareMap.servo.get("leftS");


        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);


        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {

            sleep(300);


        }
    }


    @Override
    public void loop() {


        //gyroStraight(21, 0.5, 0.01);
        //gyroTurn(0);
        // sleepMove(3000, 75, .5);
        driveForwardForTime(1, 5000);

        drive(0, 0);
        sleep(100);

        gyroTurn(60);

        driveForwardForTime(0.7, 2000);

        drive(0, 0);
        sleep(100);



        // RightServo.setPosition(90);


        telemetry.addData("Gyro: ", gyroSensor.getHeading());
    }

    @Override
    public void stop() {
        // super.stop();
        telemetry.addData("Yo mama is fat, Her weight in tons: ", gyroSensor.getHeading());
    }

}
