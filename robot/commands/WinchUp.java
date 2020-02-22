/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class WinchUp extends CommandBase {
  Winch objWinch;
  BooleanSupplier leftBooleanSupplier;
  BooleanSupplier rightBooleanSupplier;

  /**
   * Creates a new WinchUp.
   */
  public WinchUp(Winch objWinch, BooleanSupplier leftBooleanSupplier, BooleanSupplier rightBooleanSupplier) {
    this.objWinch = objWinch;
    this.leftBooleanSupplier = leftBooleanSupplier;
    this.rightBooleanSupplier = rightBooleanSupplier;
    addRequirements(objWinch);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (leftBooleanSupplier.getAsBoolean()) {
      objWinch.leftUp();
    } else {
      objWinch.leftStop();
    }
    if (rightBooleanSupplier.getAsBoolean()) {
      objWinch.rightUp();
    } else {
      objWinch.rightStop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    objWinch.rightStop();
    objWinch.leftStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
