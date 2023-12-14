public class CollisionSystem {
    public static void detectCollision(Car car, Player player, Game game){
        if(player.getCarPlayer().getRoadLane() == car.getRoadLane()){
            if (car.getPosX() + 72 >= player.getCarPlayer().getPosX() && (car.getPosY() + 100 > player.getCarPlayer().getPosY() && car.getPosY() < player.getCarPlayer().getPosY()+100)){
                //SoundEngine.playExplosion();
                game.gameOver();
            }
            else{
                //System.out.println("neni kolizia!");
            }
        }
        else{
            //System.out.println("neni kolizia!");
        }
    }
}
