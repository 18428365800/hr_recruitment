package com.recruit.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.actor.ActorRef;

import com.recruit.messages.*;

public class accountManager extends AbstractActor
{

    private ActorRef recruitManActorRef;

    public static Props props(ActorRef ref)
    {
        return Props.create(accountManager.class,() -> new accountManager(ref));
    }

    public accountManager(ActorRef recruitManActorRef)
    {
        this.recruitManActorRef = recruitManActorRef;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Position.class,msg -> {
                    recruitManActorRef.tell(msg,getSelf());
                    System.out.println("hello i am accountManager the job is " + msg.getJob_name());
                }).build();
    }
}
