package game.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * This designates a method as a work in progress.
 * @author Jay Clegg
 *
 */
@Target(ElementType.METHOD)
public @interface WIP
{
}