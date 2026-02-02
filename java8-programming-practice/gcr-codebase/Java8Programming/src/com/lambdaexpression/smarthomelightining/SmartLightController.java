package com.lambdaexpression.smarthomelightining; 
import java.util.HashMap;
import java.util.Map;

public class SmartLightController {
	    private Map<String,LightAction>actions=new HashMap<>();
	    public void addAction(String trigger, LightAction action) {
	        actions.put(trigger, action);
	    }
	    public void execute(String trigger) {
	        LightAction action=actions.get(trigger);
	        if (action!=null) {
	            action.activate();
	        } 
	        else {
	            System.out.println("No action " + trigger);
	        }
	    }
	}

