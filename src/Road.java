import fri.shapesge.Rectangle;


public class Road {
    public Road() {
        Rectangle asphalt = new Rectangle(200 , 0);
        asphalt.changeColor("#000000");
        asphalt.changeSize(300, 600);
        asphalt.makeVisible();

        Rectangle laneOne = new Rectangle(280,0);
        laneOne.changeColor("#FFFFFF");
        laneOne.changeSize(15, 600);
        laneOne.makeVisible();

        Rectangle laneTwo = new Rectangle(400,0);
        laneTwo.changeColor("#FFFFFF");
        laneTwo.changeSize(15, 600);
        laneTwo.makeVisible();

        Rectangle horinzotalLaneOne = new Rectangle(200,100);
        horinzotalLaneOne.changeColor("#000000");
        horinzotalLaneOne.changeSize(300, 15);
        horinzotalLaneOne.makeVisible();

        Rectangle horinzotalLaneTwo = new Rectangle(200,200);
        horinzotalLaneTwo.changeColor("#000000");
        horinzotalLaneTwo.changeSize(300, 15);
        horinzotalLaneTwo.makeVisible();

        Rectangle horinzotalLaneThree = new Rectangle(200,300);
        horinzotalLaneThree.changeColor("#000000");
        horinzotalLaneThree.changeSize(300, 15);
        horinzotalLaneThree.makeVisible();

        Rectangle horinzotalLaneFour = new Rectangle(200,400);
        horinzotalLaneFour.changeColor("#000000");
        horinzotalLaneFour.changeSize(300, 15);
        horinzotalLaneFour.makeVisible();

        Rectangle horinzotalLaneFive = new Rectangle(200,500);
        horinzotalLaneFive.changeColor("#000000");
        horinzotalLaneFive.changeSize(300, 15);
        horinzotalLaneFive.makeVisible();
    }
}

