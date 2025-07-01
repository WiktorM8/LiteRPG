package Framework.Event.Listener;

import Framework.Event.EventInterface;

public interface EventListenerInterface<EventClass extends EventInterface> {
    void handleEvent(EventClass event);
}
