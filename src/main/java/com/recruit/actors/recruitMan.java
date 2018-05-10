package com.recruit.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;
import com.recruit.messages.Position;
import akka.actor.ActorRef;

public class recruitMan extends AbstractActor
{

    private ActorRef jobSeekerRef;

    public static Props props(ActorRef ref)
    {
        return Props.create(recruitMan.class,() -> new recruitMan(ref));
    }

    public recruitMan(ActorRef jobSeekerRef)
    {
       this. jobSeekerRef = jobSeekerRef;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Position.class, msg -> {
                    jobSeekerRef.tell(msg,getSelf());
                    System.out.println("hello i am recruitMan the job is " + msg.getJob_name());
                }).build();
    }
}
