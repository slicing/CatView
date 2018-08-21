package gof;

import java.util.ArrayList;
import java.util.List;

interface IPublisher{
    void register(ISubscriber obj);
    void unregister(ISubscriber obj);
    void notifyObservers();

    Object getUpdate();
}

interface ISubscriber{
    void update();
    void setPublisher(IPublisher publisher);
}

class MyPublisher implements IPublisher{


    private List<ISubscriber> subscriberList;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyPublisher() {

    }

    @Override
    public void register(ISubscriber obj) {
        if(obj == null){
            throw new NullPointerException("Null Subscriber");
        }
        synchronized (MUTEX){
            if(!subscriberList.contains(obj)){
                subscriberList.add(obj);
            }
            obj.setPublisher(this);
        }
    }

    @Override
    public void unregister(ISubscriber obj) {
        synchronized (MUTEX){
            subscriberList.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<ISubscriber> subscribers;
        synchronized (MUTEX){
            if(!changed){
                return;
            }
            subscribers = new ArrayList<>(this.subscriberList);
            this.changed = false;
        }
        for (ISubscriber obj:subscribers){
            obj.update();
        }
    }

    @Override
    public Object getUpdate() {
        return this.message;
    }

    public void postMessage(String msg){
        System.out.println("message posed to topic : " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}


class TopicSubscriber implements ISubscriber{
    private String name;
    private IPublisher topic;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String)topic.getUpdate();
        if(message == null){
            System.out.println(name + "::No new message");
        }else{
            System.out.println(message);
        }
    }

    @Override
    public void setPublisher(IPublisher publisher) {
        this.topic = publisher;
    }
}
public class DemoObserver {
    public static void main(String[] args) {
        MyPublisher publisher = new MyPublisher();

        ISubscriber hanhan1 = new TopicSubscriber("Tom Han");
        ISubscriber hanhan2 = new TopicSubscriber("Smith Han");
        ISubscriber hanhan3 = new TopicSubscriber("Jerry Han");
        publisher.register(hanhan1);
        publisher.register(hanhan2);
        publisher.register(hanhan3);
        //hanhan1.update();
    }
}
