package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Choo Choo on 12/30/2015.
 */
public class BlueFarSideAutonomous extends Gyro {
    Servo servoOne;
    Servo servoTwo;


    private int state = 0;
    private int x = 0;
    static int MARGIN = 2;
    private int turnValue = 0;

    @Override
    public void init() {
        servoOne = hardwareMap.servo.get("arm");
        servoTwo = hardwareMap.servo.get("leftS");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(400);
        }
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        telemetry.addData("State: ", state);
    }

    @Override
    public void start() {
        super.start();

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);

    }

    @Override
    public void loop() {
        telemetry.addData("Gyro Value", gyroSensor.getHeading());
        switch (state) {
            case 0:
                resetEncoders();
                state++;
                break;
            case 1: // move 1 square forward
                useEncoders();

                double count = calculateEncoderCountFromDistance(62);

                setDrivePower(0.3, 0.3);

                //
                // Have the motor shafts turned the required amount?
                //
                // If they haven't, then the op-mode remains in this state (i.e this
                // block will be executed the next time this method is called).
                //
                if (haveEncodersReached(count, count)) {

                    //
                    // Stop the motors.
                    //
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
                break;

            case 2:
                if (haveDriverEncodersReset()) {
                    state++;
                }

                break;
            case 3:
                // turn 45 degrees clockwise
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(45, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
                break;
            case 4: // move 3 squares diagonally
                useEncoders();
                count = calculateEncoderCountFromDistance(211);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
                break;
            case 5:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 6:
                // turn another 45 degrees clockwise
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(90, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
                break;

            case 7:
                // move till wall
                count = calculateEncoderCountFromDistance(90);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
                break;
            case 8:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 9:
                //lift arm to drop climbers in beacon
                servoOne.setPosition(1);
                if (servoOne.getPosition() == 1) {
                    state++;

                }
                break;
            case 10:
                //return arm to original position
                servoOne.setPosition(0);
                if (servoOne.getPosition() == 0) {
                    state++;

                }
                break;
            case 11:
                //move back 1/2 square
                count = calculateEncoderCountFromDistance(30);
                setDrivePower(-0.3, -0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
            case 12:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 13:
                // rotate 90 degrees clockwise
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(180, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
            case 14:
                //move forward about 1 square(a little less)
                count = calculateEncoderCountFromDistance(50);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
            case 15:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 16:
                // rotate 45 degrees clockwise
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(225, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
            case 17:
                //move forward  1 square diagonally to clear debris in front of mountain
                count = calculateEncoderCountFromDistance(84);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
            case 18:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 19:
                //move back to the middle of the mountain
                count = calculateEncoderCountFromDistance(35);
                setDrivePower(-0.3, -0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
            case 20:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 21:
                // rotate 45 degrees counter-clockwise
                setDrivePowerNoEnc(0.08f, -0.08f);
                if (hasGyroReachedValue(135, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
            case 22:
                //move up the mountain
                count = calculateEncoderCountFromDistance(20);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
            case 23:
                //Check to make sure encoders are reset
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;

            default:
                break;
        }

    }


}
