package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
<<<<<<< HEAD
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by heel7_000 on 12/4/2015.
 */
public class Autonomous extends Gyro {
    Servo one;
    Servo two;
    GyroSensor gyroSensor;


    @Override
    public void init() {
        one = hardwareMap.servo.get("arm");
        two = hardwareMap.servo.get("leftS");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(400);
        }

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
=======
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;


public class Autonomous extends Gyro {
    Servo RightServo;
    Servo LeftServo;


    double ServoPosition = 0.7;

    @Override
    public void init() {
        RightServo = hardwareMap.servo.get("arm");
        LeftServo = hardwareMap.servo.get("leftS");


        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(100);
        }
>>>>>>> master
    }

    @Override
    public void loop() {
<<<<<<< HEAD
        //Gyro myGyro = new Gyro();
       Gyro myGyro = new Gyro();
        //myGyro.moveCentimetersTyre(200, 9.75,.3);
        myGyro.gyroTurn(90);
=======
        sleepMove(3000, 0, 1);

        //gyroTurn(89, 91);
        // sleepMove(3000, 75, .5);

        //leftMotor.setPower(0);
        //rightMotor.setPower(0);


        telemetry.addData("Gyro: ", gyroSensor.getHeading());
>>>>>>> master
    }

    @Override
    public void stop() {
<<<<<<< HEAD
        super.stop();
    }
=======
        // super.stop();
        System.out.println("Yo mama is fat");
    }

>>>>>>> master
}
