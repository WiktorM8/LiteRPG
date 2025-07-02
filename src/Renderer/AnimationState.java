package Renderer;

public class AnimationState {
    private int currentFrame = 0;
    private long lastUpdate = System.currentTimeMillis();

    public int getCurrentFrameIndex(AnimatedTexture texture) {
        long now = System.currentTimeMillis();
        if (now - lastUpdate >= texture.getFrameTime()) {
            currentFrame = (currentFrame + 1) % texture.getFrameCount();
            lastUpdate = now;
        }
        return currentFrame;
    }

    public void reset() {
        currentFrame = 0;
        lastUpdate = System.currentTimeMillis();
    }
}
