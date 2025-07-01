package Framework.Event.Dispatcher;

import Framework.Event.EventInterface;
import Framework.Event.Listener.EventListenerInterface;

import java.util.ArrayList;

public interface EventDispatcherInterface<EventClass extends EventInterface> {
    void addListener(EventListenerInterface<EventClass> listener);
    void removeListener(EventListenerInterface<EventClass> listener);
    ArrayList<EventListenerInterface<EventClass>> getListeners();
    void dispatch(EventClass event);
}