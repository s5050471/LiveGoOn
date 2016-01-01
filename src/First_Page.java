import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class First_Page extends Thread{

	protected Shell shlLiveGoon;
	private Table table;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			First_Page window = new First_Page();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLiveGoon.open();
		shlLiveGoon.layout();
		shlLiveGoon.addListener(SWT.Close, new Listener() {
			  @Override
		      public void handleEvent(Event event) {
				  System.out.println("Exit");
				  System.exit(0);
		      }
		});
		//new First_Page().start();
		afterLoad();
		while (!shlLiveGoon.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		shlLiveGoon = new Shell();
		shlLiveGoon.setSize(800, 600);
		shlLiveGoon.setText("LIVE GoOn");
		shlLiveGoon.setLayout(null);
		
		Menu menu = new Menu(shlLiveGoon, SWT.BAR);
		shlLiveGoon.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setText("Exit");
		
		MenuItem mntmView = new MenuItem(menu, SWT.NONE);
		mntmView.setText("View");
		
		MenuItem mntmSettig = new MenuItem(menu, SWT.CASCADE);
		mntmSettig.setText("Option");
		
		Menu menu_2 = new Menu(mntmSettig);
		mntmSettig.setMenu(menu_2);
		
		MenuItem mntmOption = new MenuItem(menu_2, SWT.NONE);
		mntmOption.setText("Setting");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.NONE);
		mntmHelp.setText("Help");
		
		Label label = new Label(shlLiveGoon, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(176, 10, 2, 521);
		
		Button btnNewButton = new Button(shlLiveGoon, SWT.NONE);
		btnNewButton.setBounds(43, 35, 75, 25);
		btnNewButton.setText("LIVE");
		
		Button btnNewButton_1 = new Button(shlLiveGoon, SWT.NONE);
		btnNewButton_1.setBounds(43, 86, 75, 25);
		btnNewButton_1.setText("Upload");
		
		Button btnNewButton_2 = new Button(shlLiveGoon, SWT.NONE);
		btnNewButton_2.setBounds(43, 141, 75, 25);
		btnNewButton_2.setText("Media File");
		
		composite_1 = new Composite(shlLiveGoon, SWT.EMBEDDED);
		composite_1.setBounds(184, 10, 590, 521);
		composite_1.setLayout(null);
		composite_1.setVisible(false);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				composite.setVisible(true);
				composite_1.setVisible(false);
				composite_2.setVisible(false);
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				composite.setVisible(false);
				composite_1.setVisible(true);
				composite_2.setVisible(false);
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				composite.setVisible(false);
				composite_1.setVisible(false);
				composite_2.setVisible(true);
			}
		});
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 590, 291);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(40);
		tblclmnNewColumn.setText("No.");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Name");
		
		TableColumn tblclmnSize = new TableColumn(table, SWT.NONE);
		tblclmnSize.setWidth(100);
		tblclmnSize.setText("Size");
		
		TableColumn tblclmnProgress = new TableColumn(table, SWT.NONE);
		tblclmnProgress.setWidth(100);
		tblclmnProgress.setText("Progress");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Total Upload");
		
		TableColumn tblclmnUploadSpeed = new TableColumn(table, SWT.NONE);
		tblclmnUploadSpeed.setWidth(100);
		tblclmnUploadSpeed.setText("Upload Speed");
		
		TabFolder tabFolder = new TabFolder(composite_1, SWT.NONE);
		tabFolder.setBounds(0, 306, 590, 215);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Summary");
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("Statistics");
		
		composite_2 = new Composite(shlLiveGoon, SWT.EMBEDDED);
		composite_2.setBounds(184, 10, 590, 521);
		composite_2.setVisible(false);
		
		table_1 = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(0, 0, 598, 521);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tbl1clmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tbl1clmnNewColumn.setWidth(100);
		tbl1clmnNewColumn.setText("Name");
		
		TableColumn tbl1clmnSize = new TableColumn(table_1, SWT.NONE);
		tbl1clmnSize.setWidth(100);
		tbl1clmnSize.setText("Size");
		
		TableColumn tbl1clmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		tbl1clmnNewColumn_1.setWidth(100);
		tbl1clmnNewColumn_1.setText("Time");
		
		TableColumn tbl1clmnDate = new TableColumn(table_1, SWT.NONE);
		tbl1clmnDate.setWidth(100);
		tbl1clmnDate.setText("Date");
		

	}
	Composite composite,composite_1,composite_2;
	private Table table_1;
	protected void afterLoad(){
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.open();
		
		WebcamPanel cam = new WebcamPanel(webcam);
		cam.setBounds(0, 0, 590, 523);
		cam.setFPSDisplayed(true);
		cam.setMirrored(true);

		composite = new Composite(shlLiveGoon, SWT.EMBEDDED);
		composite.setBounds(184, 10, 590, 521);
		
		Frame frame = SWT_AWT.new_Frame(composite);
		frame.setLayout(null);
		
		frame.add(cam);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void run(){
		afterLoad();
	}
}
