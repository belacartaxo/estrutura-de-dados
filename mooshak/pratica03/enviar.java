class Rectangle {
    Point p1, p2;
    int larg, comp;
    
    Rectangle(int x1,int y1,int x2,int y2){
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        sides();
    }

    Rectangle(Point point1, Point point2){
        p1 = point1;
        p2 = point2;
        sides();
    }

    private void sides(){
        larg = p2.y - p1.y;
        comp = p2.x - p1.x;
    }

    public int area(){
        return larg * comp; 
    }

    
    public int perimeter(){
        return larg * 2 + comp * 2;
    }

    public boolean pointInside(Point p){
        return (p1.x <= p.x && p.x <= p2.x && p1.y <= p.y && p.y <= p2.y);
    }

    public boolean rectangleInside(Rectangle r) {
        return (pointInside(r.p1) && pointInside(r.p2));
    }
}
