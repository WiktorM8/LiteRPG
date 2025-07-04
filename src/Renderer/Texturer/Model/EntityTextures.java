package Renderer.Texturer.Model;

import Renderer.Texturer.Enum.EntityTexture;

public class EntityTextures {
    private final EntityTexture standingTexture;
    private final EntityTexture walkingUpTexture;
    private final EntityTexture walkingDownTexture;
    private final EntityTexture walkingLeftTexture;
    private final EntityTexture walkingRightTexture;

    public EntityTextures(
            EntityTexture standingTexture,
            EntityTexture walkingUpTexture,
            EntityTexture walkingDownTexture,
            EntityTexture walkingLeftTexture,
            EntityTexture walkingRightTexture
    ) {
        this.standingTexture = standingTexture;
        this.walkingUpTexture = walkingUpTexture;
        this.walkingDownTexture = walkingDownTexture;
        this.walkingLeftTexture = walkingLeftTexture;
        this.walkingRightTexture = walkingRightTexture;
    }

    public EntityTexture getStandingTexture() {
        return standingTexture;
    }
    public EntityTexture getWalkingUpTexture() {
        return walkingUpTexture;
    }
    public EntityTexture getWalkingDownTexture() {
        return walkingDownTexture;
    }
    public EntityTexture getWalkingLeftTexture() {
        return walkingLeftTexture;
    }
    public EntityTexture getWalkingRightTexture() {
        return walkingRightTexture;
    }
}
