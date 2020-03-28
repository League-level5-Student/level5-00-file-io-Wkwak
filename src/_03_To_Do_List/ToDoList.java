package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton("add task");
	JButton b2 = new JButton("view tasks");
	JButton b3 = new JButton("remove task");
	JButton b4 = new JButton("save list");
	JButton b5 = new JButton("load list");
	ArrayList<String> arr = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.frame();
	}

	public void frame() {

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("add task")) {
			String task = JOptionPane.showInputDialog(null, "Type in a task");
			arr.add(task);
		}
		if (e.getActionCommand().equals("view tasks")) {
			for (int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i));
			}
		}
		if (e.getActionCommand().equals("remove task")) {
			String remove = JOptionPane.showInputDialog(null, "type in the task to be removed w/o capitals");
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i).toLowerCase().equals(remove)) {
					arr.remove(i);
				}
			}
		}
		if (e.getActionCommand().equals("save list")) {
			String tasks = "";
			for (int i = 0; i < arr.size(); i++) {
				tasks += arr.get(i);
				tasks += "\n";
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/tasks.txt");
				fw.write(tasks);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("load list")) {
			//should load the most recent task list
			//places the tasks into the array 
		}
	}
}
