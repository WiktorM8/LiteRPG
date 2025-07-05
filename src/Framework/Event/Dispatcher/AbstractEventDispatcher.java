package Framework.Event.Dispatcher;

import Framework.Event.EventInterface;
import Framework.Event.Listener.EventListenerInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractEventDispatcher implements EventDispatcherInterface {
    private static final Map<Class<? extends EventInterface>, List<EventListenerInterface<? extends EventInterface>>> listenerMap =
            new HashMap<>();

    public static <T extends EventInterface> void addListener(Class<T> eventType, EventListenerInterface<T> listener) {
        listenerMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public static <T extends EventInterface> void removeListener(Class<T> eventType, EventListenerInterface<T> listener) {
        List<EventListenerInterface<? extends EventInterface>> listeners = listenerMap.get(eventType);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    public static <T extends EventInterface> List<EventListenerInterface<? extends EventInterface>> getListeners(Class<T> eventType) {
        List<EventListenerInterface<? extends EventInterface>> listeners = listenerMap.get(eventType);
        return listeners != null ? listeners : new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public static <T extends EventInterface> void dispatch(T event) {
        List<EventListenerInterface<? extends EventInterface>> listeners = listenerMap.get(event.getClass());
        if (listeners != null) {
            for (EventListenerInterface<? extends EventInterface> listener : new ArrayList<>(listeners)) {
                ((EventListenerInterface<T>) listener).handleEvent(event);
            }
        }
    }

}
