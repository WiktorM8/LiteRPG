package Framework.Event.Dispatcher;

import Framework.Event.EventInterface;
import Framework.Event.Listener.EventListenerInterface;

import java.util.ArrayList;

public abstract class AbstractEventDispatcher<EventClass extends EventInterface> implements EventDispatcherInterface<EventClass> {
    private final ArrayList<EventListenerInterface<EventClass>> listeners = new ArrayList<>();

    @Override
    public void addListener(EventListenerInterface<EventClass> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListenerInterface<EventClass> listener) {
        listeners.remove(listener);
    }

    @Override
    public ArrayList<EventListenerInterface<EventClass>> getListeners() {
        return listeners;
    }

    @Override
    public void dispatch(EventClass event) {
        for (EventListenerInterface<EventClass> listener : new ArrayList<>(listeners)) {
            listener.handleEvent(event);
        }
    }
}
