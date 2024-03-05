package MP3;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import state.DeleteState;
import state.InsertState;
import state.MarkState;
import state.MoveState;
import state.ResizeState;
import state.UnmarkState;

public class ShapeApp extends JFrame
  {
  private static final long serialVersionUID = 1L;
  private ShapeContainer shapeContainer = new ShapeContainer();
  public ShapeApp()
    {
    createMenue();
    this.add(shapeContainer);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400,400);
    this.setVisible(true);
    }
  
  public void createMenue()
    {
    JMenu menu = new JMenu("Modes");
    createMenuItem(menu, "Insert", e -> shapeContainer.setState(new InsertState()));
    createMenuItem(menu, "Move", e -> shapeContainer.setState(new MoveState()));
    createMenuItem(menu, "Delete", e -> shapeContainer.setState(new DeleteState()));
    createMenuItem(menu, "Mark", e -> shapeContainer.setState(new MarkState()));
    createMenuItem(menu, "Unmark", e -> shapeContainer.setState(new UnmarkState()));
    createMenuItem(menu, "Resize", e -> shapeContainer.setState(new ResizeState()));
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    
    JMenu shapeMenu = new JMenu("Shapes");
    createMenuItem(shapeMenu, "Circle", e -> shapeContainer.setShape(ShapeTypes.CIRCLE));
    createMenuItem(shapeMenu, "Rectangle", e -> shapeContainer.setShape(ShapeTypes.RECTANGLE));
    menuBar.add(shapeMenu);
    
    JMenu markMenu = new JMenu("Marks");
    createMenuItem(markMenu, "Fill", e -> shapeContainer.setMarkType(MarkTypes.FILL));
    createMenuItem(markMenu, "Crosshair", e -> shapeContainer.setMarkType(MarkTypes.CROSSHAIR));
    menuBar.add(markMenu);
    
    this.setJMenuBar(menuBar);
    }
  
  private void createMenuItem(JMenu menu, String label, ActionListener listener)
    {
    JMenuItem menuItem = new JMenuItem(label);
    menuItem.addActionListener(listener);
    menu.add(menuItem);
    }
  
  public static void main(String args[])
    {
    new ShapeApp(); // obs egentligen SwingUtilities ...
    }
  }
