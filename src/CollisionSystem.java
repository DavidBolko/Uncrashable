public class CollisionSystem {
    private Game game;

    public CollisionSystem(Game game) {
        this.game = game;
    }

    public void detectCollision(Car car, Player player){
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
