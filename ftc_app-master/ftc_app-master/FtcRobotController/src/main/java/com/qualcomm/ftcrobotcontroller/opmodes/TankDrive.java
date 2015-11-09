package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by heel7_000 on 9/2/2015.
 */
public class TankDrive extends OpMode {

    DcMotor urmom;
    DcMotor yo;

    public TankDrive() {
    }

    @Override
    public void init() {
        urmom = hardwareMap.dcMotor.get("right");//right forward
        yo = hardwareMap.dcMotor.get("left");
        yo.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        double rightPower = -gamepad1.left_stick_y;
        double leftPower = -gamepad1.right_stick_y;

        rightPower = Range.clip(rightPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        urmom.setPower(-leftPower);
        yo.setPower(-rightPower);


    }
}

