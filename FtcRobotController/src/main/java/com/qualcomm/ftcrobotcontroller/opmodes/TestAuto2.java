package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by heel7 on 12/29/2015.
 *
 * Autonomous program - use distances to get to beacon
 */
public class TestAuto2  extends Gyro{

    Servo servoOne;
    Servo servoTwo;
    int troll = (int) Math.random() * 55;

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
        telemetry.addData("Yo init", state);
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
            case 1: // move 2 squares
                useEncoders();

                double count = calculateEncoderCountFromDistance(109);

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
                // turn 45 degrees
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(45, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
                break;
            case 4: // move 1 1/2 squares
                useEncoders();
                count = calculateEncoderCountFromDistance(116);
                setDrivePower(0.3, 0.3);
                if (haveEncodersReached(count, count)) {
                    setDrivePower(0.0f, 0.0f);
                    resetEncoders();
                    state++;
                }
                break;
            case 5:
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 6:
                // turn another 45 degrees
                setDrivePowerNoEnc(-0.08f, +0.08f);
                if (hasGyroReachedValue(90, MARGIN)) {
                    setDrivePower(0.0f, 0.0f);
                    state++;
                }
                break;
            // move till wall
            case 7:
                count = calculateEncoderCountFromDistance(20);
                setDrivePower(0.3,0.3);
                if(haveEncodersReached(count,count)){
                    setDrivePower(0.0f,0.0f);
                    resetEncoders();
                    state++;
                }
                break;
            case 8:
                count = calculateEncoderCountFromDistance(20);
                setDrivePower(0.3, 0.3);


            default:
                break;
        }
        telemetry.addData("Random Value", troll);
    }
}