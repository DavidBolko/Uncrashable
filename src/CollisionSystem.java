public class CollisionSystem {
    public static void detectCollision(Car car, Player player, Game game){
        if(player.getCar().getRoadLane() == car.getRoadLane()){
            if (car.getPosX() + 72 >= player.getCar().getPosX() && (car.getPosY() + 100 > player.getCar().getPosY() && car.getPosY() < player.getCar().getPosY()+100)){
                player.getCar().explode();
                car.explode();
                SoundEngine.playExplosion();
                game.gameOver();
            }
        }
    }

}
