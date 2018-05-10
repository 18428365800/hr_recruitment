package com.recruit;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import com.recruit.actors.*;
import com.recruit.messages.Position;


public class Maintest
{
    public static void main(String[] args)
    {
        ActorSystem system = ActorSystem.create("hr");

        ActorRef jobSeekerActor = system.actorOf(jobSeeker.props(),"jobSeeker");
        ActorRef recruitManActor = system.actorOf(recruitMan.props(jobSeekerActor),"recruitMan");
        ActorRef accountManagerActor = system.actorOf(accountManager.props(recruitManActor),"accountManager");
        ActorRef CustomerActor = system.actorOf(Customer.props(accountManagerActor),"Customer");

        Position message = new Position(1,"java engineer","java development");

        CustomerActor.tell(message,ActorRef.noSender());
    }
}
