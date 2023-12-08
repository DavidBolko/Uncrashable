import fri.shapesge.Rectangle;


public class Road {
    private Rectangle asphalt;
    private Rectangle laneOne;
    private Rectangle laneTwo;
    private Rectangle horinzotalLaneOne;
    private Rectangle horinzotalLaneTwo;
    private Rectangle horinzotalLaneThree;
    private Rectangle horinzotalLaneFour;
    private Rectangle horinzotalLaneFive;
    public Road() {
        this.asphalt = new Rectangle(200 , 0);
        this.asphalt.changeColor("#000000");
        this.asphalt.changeSize(300, 600);
        this.asphalt.makeVisible();

        this.laneOne = new Rectangle(280,0);
        this.laneOne.changeColor("#FFFFFF");
        this.laneOne.changeSize(15, 600);
        this.laneOne.makeVisible();

        this.laneTwo = new Rectangle(400,0);
        this.laneTwo.changeColor("#FFFFFF");
        this.laneTwo.changeSize(15, 600);
        this.laneTwo.makeVisible();

        this.horinzotalLaneOne = new Rectangle(200,100);
        this.horinzotalLaneOne.changeColor("#000000");
        this.horinzotalLaneOne.changeSize(300, 15);
        this.horinzotalLaneOne.makeVisible();

        this.horinzotalLaneTwo = new Rectangle(200,200);
        this.horinzotalLaneTwo.changeColor("#000000");
        this.horinzotalLaneTwo.changeSize(300, 15);
        this.horinzotalLaneTwo.makeVisible();

        this.horinzotalLaneThree = new Rectangle(200,300);
        this.horinzotalLaneThree.changeColor("#000000");
        this.horinzotalLaneThree.changeSize(300, 15);
        this.horinzotalLaneThree.makeVisible();

        this.horinzotalLaneFour = new Rectangle(200,400);
        this.horinzotalLaneFour.changeColor("#000000");
        this.horinzotalLaneFour.changeSize(300, 15);
        this.horinzotalLaneFour.makeVisible();

        this.horinzotalLaneFive = new Rectangle(200,500);
        this.horinzotalLaneFive.changeColor("#000000");
        this.horinzotalLaneFive.changeSize(300, 15);
        this.horinzotalLaneFive.makeVisible();
    }

    public void destroyRoad(){
        this.asphalt.makeInvisible();
        this.laneOne.makeInvisible();
        this.laneTwo.makeInvisible();
        this.horinzotalLaneOne.makeInvisible();
        this.horinzotalLaneTwo.makeInvisible();
        this.horinzotalLaneThree.makeInvisible();
        this.horinzotalLaneFour.makeInvisible();
        this.horinzotalLaneFive.makeInvisible();
    }
}

