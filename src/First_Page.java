import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ProgressBar;

public class First_Page {

	protected Shell shlLiveGoon;

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

	}
}
