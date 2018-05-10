package com.recruit.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import com.recruit.messages.*;
import akka.actor.ActorSelection;
import akka.actor.ActorRef;

public class Customer extends AbstractActor
{

    private ActorRef accountMangerActorRef;

    public static Props props(ActorRef ref)
    {
        return Props.create(Customer.class, () -> new Customer(ref));
    }

    public Customer(ActorRef accountMangerActorRef)
    {
        this.accountMangerActorRef = accountMangerActorRef;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Position.class,mes -> {
                    accountMangerActorRef.tell(mes,getSelf());
                    System.out.println("hello i am Customer the job is " + mes.getJob_name());
                }).build();
    }
}
