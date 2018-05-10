package com.recruit.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import com.recruit.messages.*;

public class jobSeeker extends AbstractActor
{


    public static Props props()
    {
        return Props.create(jobSeeker.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Position.class,mes -> {
                    System.out.println("hello i am jobSeeker the job is " + mes.getJob_name());
                }).build();
    }
}
