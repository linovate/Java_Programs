package View;

import javax.swing.*;

import Controller.Controller;

import java.awt.*;
import java.awt.event.*;

/**
 * One object of class MainMenuFrame is a JFrame window that provides all the functionalities of GUI.----HL
 */
public class MainMenuFrame extends JFrame implements ActionListener,
		ItemListener {//HL

	private Container contentPane;

	private String searchResultString = " ";

	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 650;
	private static final int FRAME_X_ORIGIN = 300;
	private static final int FRAME_Y_ORIGIN = 20;

	private JPanel globalNorthPanel;
	private JButton globalNorthPanelAddButton,
			globalNorthPanelSearchButton, globalNorthPanelPrintButton,
			globalNorthPanelDeleteButton, globalNorthPanelQuitButton;

	private JScrollPane printScroll, searchScroll, deleteScroll;

	private JTextArea searchResultTextArea, printResultTextArea,
			deleteResultTextArea;

	private JTextField searchTitleTextField,deleteTitleTextField;

	private JLabel deleteResultPrompt;
	private JTextField deleteResultTextField;

	private JRadioButton[] mediaTypeRadioButtons;
	private ButtonGroup addMediaTypeGroup;
	private String[] addBtnText = { "Book", "Song", "Video", "Video Game" };

	private JCheckBox[] checkBoxForMediaType;
	private String[] checkBoxForMediaTypeText = { "Book", "Song", "Video",
			"Video Game", "All Media Types" };

	private JButton globalSouthPanelSaveButton, globalSouthPanelCancelButton,
			globalSouthPanelSearchButton,
			globalSouthPanelSearchForDeleteButton,
			globalSouthPanelDeleteButton;

	private CardLayout cardLayoutAtGlobalCenter = new CardLayout(20, 20);
	private JPanel globalCenterPanel = new JPanel(cardLayoutAtGlobalCenter);
	private JPanel blankPanelAtCenter, blankPanelAtSouth, blankPanelAtWest,

	addBookPanelAtCenter, addSongPanelAtCenter, addVideoPanelAtCenter,
			addVideoGamePanelAtCenter,

			searchPanelAtCenter, searchResultPanelAtCenter, printResultPanelAtCenter,

			deletePanelAtCenter, deleteResultPanelAtCenter;

	private CardLayout cardLayoutAtGlobalWest = new CardLayout(20, 20);
	private JPanel globalWestPanel = new JPanel(cardLayoutAtGlobalWest);
	private JPanel addMediaTypePanel, nonAddMediaTypePanel;

	private CardLayout cardLayoutAtGlobalSouth = new CardLayout(20, 20);
	private JPanel globalSouthPanel = new JPanel(cardLayoutAtGlobalSouth);
	private JPanel southForAddPanel, southForSearchPanel, southForDeletePanel;

	private JLabel authorPrompt, artistPrompt, genrePrompt, starPrompt,

	formatPromptBook, titlePromptBook, locationPromptBook, notePromptBook,
			formatPromptSong, titlePromptSong, locationPromptSong,
			notePromptSong, formatPromptVideo, titlePromptVideo,
			locationPromptVideo, notePromptVideo, formatPromptVideoGame,
			titlePromptVideoGame, locationPromptVideoGame, notePromptVideoGame;

	private JTextField authorTextField, artistTextField, genreTextField,
			starTextField,

			formatTextFieldBook, titleTextFieldBook, locationTextFieldBook,
			noteTextFieldBook, formatTextFieldSong, titleTextFieldSong,
			locationTextFieldSong, noteTextFieldSong, formatTextFieldVideo,
			titleTextFieldVideo, locationTextFieldVideo, noteTextFieldVideo,
			formatTextFieldVideoGame, titleTextFieldVideoGame,
			locationTextFieldVideoGame, noteTextFieldVideoGame;

	/*
	 * Constructor of class MainMenuFrame. It creates and initializes all the GUI components.----HL
	 */
	
	public MainMenuFrame() {

		setTitle("Personal Media Library Version 3.0");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(true);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

		contentPane = getContentPane();
		contentPane.setBackground(Color.green);
		contentPane.setLayout(new BorderLayout(20, 20));

		globalNorthPanel = new JPanel();
		globalNorthPanel
				.setBorder(BorderFactory
						.createTitledBorder("Click the button corresponds to your operation"));
		globalNorthPanel.setLayout(new GridLayout(1, 5));

		globalNorthPanelAddButton = new JButton("Add");
		globalNorthPanelAddButton.addActionListener(this);

		globalNorthPanelSearchButton = new JButton("Search");
		globalNorthPanelSearchButton.addActionListener(this);

		globalNorthPanelPrintButton = new JButton("Print  All");
		globalNorthPanelPrintButton.addActionListener(this);

		globalNorthPanelDeleteButton = new JButton("Delete");
		globalNorthPanelDeleteButton.addActionListener(this);

		globalNorthPanelQuitButton = new JButton("Save & Quit");
		globalNorthPanelQuitButton.addActionListener(this);

		globalNorthPanel.add(globalNorthPanelAddButton);
		globalNorthPanel.add(globalNorthPanelSearchButton);
		globalNorthPanel.add(globalNorthPanelPrintButton);
		globalNorthPanel.add(globalNorthPanelDeleteButton);
		globalNorthPanel.add(globalNorthPanelQuitButton);

		contentPane.add(globalNorthPanel, BorderLayout.NORTH);

		makeblankPanelAtCenter();
		makeblankPanelAtWest();

		makeAddBookPanelAtCenter();
		makeAddSongPanelAtCenter();
		makeAddVideoPanelAtCenter();
		makeAddVideoGamePanelAtCenter();

		makeSearchPanelAtCenter();
		makeSearchResultPanelAtCenter();

		makePrintResultPanelAtCenter();

		makeDeletePanelAtCenter();
		makeDeleteResultPanelAtCenter();

		printScroll = new JScrollPane(printResultTextArea);
		printScroll.setPreferredSize(new Dimension(297, 350));
		printResultPanelAtCenter.add(printScroll);

		searchScroll = new JScrollPane(searchResultTextArea);
		searchScroll.setPreferredSize(new Dimension(297, 350));
		searchResultPanelAtCenter.add(searchScroll);

		deleteScroll = new JScrollPane(deleteResultTextArea);
		deleteScroll.setPreferredSize(new Dimension(297, 350));
		deleteResultPanelAtCenter.add(deleteScroll);

		globalCenterPanel.add(blankPanelAtCenter, "BlankPanelCardAtCenter");
		globalCenterPanel.add(addBookPanelAtCenter, "AddBookCardAtCenter");
		globalCenterPanel.add(addSongPanelAtCenter, "AddSongCardAtCenter");
		globalCenterPanel.add(addVideoPanelAtCenter, "AddVideoCardAtCenter");
		globalCenterPanel.add(addVideoGamePanelAtCenter,
				"AddVideoGameCardAtCenter");
		globalCenterPanel.add(searchPanelAtCenter, "SearchCardAtCenter");
		globalCenterPanel.add(searchResultPanelAtCenter,
				"SearchResultCardAtCenter");

		globalCenterPanel.add(printResultPanelAtCenter,
				"PrintResultCardAtCenter");
		globalCenterPanel.add(deletePanelAtCenter, "DeleteCardAtCenter");
		globalCenterPanel.add(deleteResultPanelAtCenter,
				"DeleteResultCardAtCenter");

		contentPane.add(globalCenterPanel, BorderLayout.CENTER);

		makeAddMediaTypePanelAtWest();
		makeNonAddMediaTypePanelAtWest();

		globalWestPanel.add(addMediaTypePanel, "AddMediaTypePanelAtWestCard");
		globalWestPanel.add(nonAddMediaTypePanel,
				"NonAddMediaTypePanelAtWestCard");
		globalWestPanel.add(blankPanelAtWest, "BlankPanelAtWestCard");

		makeblankPanelAtSouth();
		makeSouthPanelOfAdd();
		makeSouthPanelOfSearch();
		makeSouthPanelOfDelete();

		globalSouthPanel.add(blankPanelAtSouth, "BlankPanelCardAtSouth");
		globalSouthPanel.add(southForAddPanel, "southForAddCard");
		globalSouthPanel.add(southForSearchPanel, "southForSearchCard");
		globalSouthPanel.add(southForDeletePanel, "southForDeleteCard");

		JOptionPane.showMessageDialog(this,
				"Welcome to Personal Media Library Made By Team 2 !");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	/*
	 * Makes the blank JPanel that will be displayed at the Center region of contentPane border layout.----HL
	 */
	public void makeblankPanelAtCenter() {
		blankPanelAtCenter = new JPanel();
		blankPanelAtCenter.setLayout(new FlowLayout());
	}

	/*
	 * Makes the blank JPanel that will be displayed at the west region of contentPane border layout.----HL
	 */
	public void makeblankPanelAtWest() {
		blankPanelAtWest = new JPanel();
		blankPanelAtWest.setLayout(new FlowLayout());
	}

	/*
	 * Makes the blank JPanel that will be displayed at the south region of contentPane border layout.----HL
	 */
	public void makeblankPanelAtSouth() {
		blankPanelAtSouth = new JPanel();
		blankPanelAtSouth.setLayout(new FlowLayout());
	}

	
	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout when user try to add a book.----HL
	 */
	public void makeAddBookPanelAtCenter() {

		addBookPanelAtCenter = new JPanel();
		addBookPanelAtCenter
				.setBorder(BorderFactory
						.createTitledBorder("Please input information of the BOOK in text fields below"));
		addBookPanelAtCenter.setLayout(new FlowLayout());

		formatPromptBook = new JLabel("Format:");
		addBookPanelAtCenter.add(formatPromptBook);

		formatTextFieldBook = new JTextField();
		formatTextFieldBook.setColumns(38);
		addBookPanelAtCenter.add(formatTextFieldBook);
		formatTextFieldBook.addActionListener(this);

		titlePromptBook = new JLabel("*Title:");
		addBookPanelAtCenter.add(titlePromptBook);

		titleTextFieldBook = new JTextField();
		titleTextFieldBook.setColumns(38);
		addBookPanelAtCenter.add(titleTextFieldBook);
		titleTextFieldBook.addActionListener(this);

		locationPromptBook = new JLabel("Location:");
		addBookPanelAtCenter.add(locationPromptBook);

		locationTextFieldBook = new JTextField();
		locationTextFieldBook.setColumns(38);
		addBookPanelAtCenter.add(locationTextFieldBook);
		locationTextFieldBook.addActionListener(this);

		notePromptBook = new JLabel("Note:");
		addBookPanelAtCenter.add(notePromptBook);

		noteTextFieldBook = new JTextField();
		noteTextFieldBook.setColumns(38);
		addBookPanelAtCenter.add(noteTextFieldBook);
		noteTextFieldBook.addActionListener(this);

		authorPrompt = new JLabel("Author:");
		addBookPanelAtCenter.add(authorPrompt);

		authorTextField = new JTextField();
		authorTextField.setColumns(38);
		addBookPanelAtCenter.add(authorTextField);
		authorTextField.addActionListener(this);

		validate();
	}

	
	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout when user try to add a song.----HL
	 */
	public void makeAddSongPanelAtCenter() {

		addSongPanelAtCenter = new JPanel();
		addSongPanelAtCenter
				.setBorder(BorderFactory
						.createTitledBorder("Please input information of the SONG in text fields below"));
		addSongPanelAtCenter.setLayout(new FlowLayout());

		formatPromptSong = new JLabel("Format:");
		addSongPanelAtCenter.add(formatPromptSong);

		formatTextFieldSong = new JTextField();
		formatTextFieldSong.setColumns(38);
		addSongPanelAtCenter.add(formatTextFieldSong);
		formatTextFieldSong.addActionListener(this);

		titlePromptSong = new JLabel("*Title:");
		addSongPanelAtCenter.add(titlePromptSong);

		titleTextFieldSong = new JTextField();
		titleTextFieldSong.setColumns(38);
		addSongPanelAtCenter.add(titleTextFieldSong);
		titleTextFieldSong.addActionListener(this);

		locationPromptSong = new JLabel("Location:");
		addSongPanelAtCenter.add(locationPromptSong);

		locationTextFieldSong = new JTextField();
		locationTextFieldSong.setColumns(38);
		addSongPanelAtCenter.add(locationTextFieldSong);
		locationTextFieldSong.addActionListener(this);

		notePromptSong = new JLabel("Note:");
		addSongPanelAtCenter.add(notePromptSong);

		noteTextFieldSong = new JTextField();
		noteTextFieldSong.setColumns(38);
		addSongPanelAtCenter.add(noteTextFieldSong);
		noteTextFieldSong.addActionListener(this);

		artistPrompt = new JLabel("Artist:");
		addSongPanelAtCenter.add(artistPrompt);

		artistTextField = new JTextField();
		artistTextField.setColumns(38);
		addSongPanelAtCenter.add(artistTextField);
		artistTextField.addActionListener(this);

		genrePrompt = new JLabel("Genre:");
		addSongPanelAtCenter.add(genrePrompt);

		genreTextField = new JTextField();
		genreTextField.setColumns(38);
		addSongPanelAtCenter.add(genreTextField);
		genreTextField.addActionListener(this);

		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout when user try to add a video.----HL
	 */
	public void makeAddVideoPanelAtCenter() {

		addVideoPanelAtCenter = new JPanel();
		addVideoPanelAtCenter
				.setBorder(BorderFactory
						.createTitledBorder("Please input information of the VIDEO in text fields below"));
		addVideoPanelAtCenter.setLayout(new FlowLayout());

		formatPromptVideo = new JLabel("Format:");
		addVideoPanelAtCenter.add(formatPromptVideo);

		formatTextFieldVideo = new JTextField();
		formatTextFieldVideo.setColumns(38);
		addVideoPanelAtCenter.add(formatTextFieldVideo);
		formatTextFieldVideo.addActionListener(this);

		titlePromptVideo = new JLabel("*Title:");
		addVideoPanelAtCenter.add(titlePromptVideo);

		titleTextFieldVideo = new JTextField();
		titleTextFieldVideo.setColumns(38);
		addVideoPanelAtCenter.add(titleTextFieldVideo);
		titleTextFieldVideo.addActionListener(this);

		locationPromptVideo = new JLabel("Location:");
		addVideoPanelAtCenter.add(locationPromptVideo);

		locationTextFieldVideo = new JTextField();
		locationTextFieldVideo.setColumns(38);
		addVideoPanelAtCenter.add(locationTextFieldVideo);
		locationTextFieldVideo.addActionListener(this);

		notePromptVideo = new JLabel("Note:");
		addVideoPanelAtCenter.add(notePromptVideo);

		noteTextFieldVideo = new JTextField();
		noteTextFieldVideo.setColumns(38);
		addVideoPanelAtCenter.add(noteTextFieldVideo);
		noteTextFieldVideo.addActionListener(this);

		starPrompt = new JLabel("Star:");
		addVideoPanelAtCenter.add(starPrompt);

		starTextField = new JTextField();
		starTextField.setColumns(38);
		addVideoPanelAtCenter.add(starTextField);
		starTextField.addActionListener(this);

		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout when user try to add a video game.----HL
	 */
	public void makeAddVideoGamePanelAtCenter() {

		addVideoGamePanelAtCenter = new JPanel();
		addVideoGamePanelAtCenter
				.setBorder(BorderFactory
						.createTitledBorder("Please input information of the VIDEO GAME in text fields below"));
		addVideoGamePanelAtCenter.setLayout(new FlowLayout());

		formatPromptVideoGame = new JLabel("Format:");
		addVideoGamePanelAtCenter.add(formatPromptVideoGame);

		formatTextFieldVideoGame = new JTextField();
		formatTextFieldVideoGame.setColumns(38);
		addVideoGamePanelAtCenter.add(formatTextFieldVideoGame);
		formatTextFieldVideoGame.addActionListener(this);

		titlePromptVideoGame = new JLabel("*Title:");
		addVideoGamePanelAtCenter.add(titlePromptVideoGame);

		titleTextFieldVideoGame = new JTextField();
		titleTextFieldVideoGame.setColumns(38);
		addVideoGamePanelAtCenter.add(titleTextFieldVideoGame);
		titleTextFieldVideoGame.addActionListener(this);

		locationPromptVideoGame = new JLabel("Location:");
		addVideoGamePanelAtCenter.add(locationPromptVideoGame);

		locationTextFieldVideoGame = new JTextField();
		locationTextFieldVideoGame.setColumns(38);
		addVideoGamePanelAtCenter.add(locationTextFieldVideoGame);
		locationTextFieldVideoGame.addActionListener(this);

		notePromptVideoGame = new JLabel("Note:");
		addVideoGamePanelAtCenter.add(notePromptVideoGame);

		noteTextFieldVideoGame = new JTextField();
		noteTextFieldVideoGame.setColumns(38);
		addVideoGamePanelAtCenter.add(noteTextFieldVideoGame);
		noteTextFieldVideoGame.addActionListener(this);

		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout when user try to search.----HL
	 */
	public void makeSearchPanelAtCenter() {

		searchPanelAtCenter = new JPanel();
		searchPanelAtCenter.setBorder(BorderFactory
				.createTitledBorder("SEARCH"));
		searchPanelAtCenter.setLayout(new FlowLayout());

		JLabel searchTitlePrompt = new JLabel("Title:  ");
		searchPanelAtCenter.add(searchTitlePrompt);
		searchTitleTextField = new JTextField();
		searchTitleTextField.setColumns(38);
		searchPanelAtCenter.add(searchTitleTextField);
		searchTitleTextField.addActionListener(this);
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout after each search.----HL
	 */
	public void makeSearchResultPanelAtCenter() {

		searchResultPanelAtCenter = new JPanel();
		searchResultPanelAtCenter.setBorder(BorderFactory
				.createTitledBorder("SEARCH RESULT"));
		searchResultPanelAtCenter.setLayout(new FlowLayout());
		searchResultTextArea = new JTextArea();
		searchResultPanelAtCenter.add(searchResultTextArea);
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout after user click "Print All" button.----HL
	 */
	public void makePrintResultPanelAtCenter() {

		printResultPanelAtCenter = new JPanel();
		printResultPanelAtCenter.setBorder(BorderFactory
				.createTitledBorder("PRINT RESULT"));
		printResultPanelAtCenter.setLayout(new FlowLayout());
		printResultTextArea = new JTextArea();
		printResultPanelAtCenter.add(printResultTextArea);
	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout after user click "Delete" button.----HL
	 */
	public void makeDeletePanelAtCenter() {

		deletePanelAtCenter = new JPanel();
		deletePanelAtCenter
				.setBorder(BorderFactory
						.createTitledBorder("DELETE AN ENTRY. YOU NEED TO SEARCH IT FIRST."));
		deletePanelAtCenter.setLayout(new FlowLayout());

		JLabel titlePrompt = new JLabel("Title:");
		deletePanelAtCenter.add(titlePrompt);
		deleteTitleTextField = new JTextField();
		deleteTitleTextField.setColumns(38);
		deletePanelAtCenter.add(deleteTitleTextField);
		deleteTitleTextField.addActionListener(this);

		globalSouthPanelSearchForDeleteButton = new JButton(
				"Search My Selection(s)");
		globalSouthPanelSearchForDeleteButton.addActionListener(this);
		deletePanelAtCenter.add(globalSouthPanelSearchForDeleteButton);

	}

	/*
	 * Makes the JPanel that will be displayed at the Center region of contentPane border layout after search for delete an entry is done.----HL
	 */
	public void makeDeleteResultPanelAtCenter() {

		deleteResultPanelAtCenter = new JPanel();
		deleteResultPanelAtCenter.setBorder(BorderFactory
				.createTitledBorder("SEARCH RESULT FOR DELETE"));
		deleteResultPanelAtCenter.setLayout(new FlowLayout());

		deleteResultTextArea = new JTextArea();
		deleteResultTextArea.setColumns(30);
		deleteResultPanelAtCenter.add(deleteResultTextArea);
	}
	
	/*
	 * Makes the JPanel that will be displayed at the west region of contentPane border layout when user try to add an item.----HL
	 */
	public void makeAddMediaTypePanelAtWest() {

		addMediaTypePanel = new JPanel();
		addMediaTypePanel.setBorder(BorderFactory
				.createTitledBorder("Media Type"));
		addMediaTypePanel.setLayout(new GridLayout(4, 1));

		addMediaTypeGroup = new ButtonGroup();
		mediaTypeRadioButtons = new JRadioButton[addBtnText.length];

		for (int i = 0; i < mediaTypeRadioButtons.length; i++) {

			mediaTypeRadioButtons[i] = new JRadioButton(addBtnText[i]);
			mediaTypeRadioButtons[i].addItemListener(this);
			addMediaTypeGroup.add(mediaTypeRadioButtons[i]);
			addMediaTypePanel.add(mediaTypeRadioButtons[i]);
		}
		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the west region of contentPane border layout when user try to search,
	 *  print all or delete.----HL
	 */
	public void makeNonAddMediaTypePanelAtWest() {

		nonAddMediaTypePanel = new JPanel();
		nonAddMediaTypePanel.setBorder(BorderFactory
				.createTitledBorder("Media Type(s)"));
		nonAddMediaTypePanel.setLayout(new GridLayout(5, 1));
		checkBoxForMediaType = new JCheckBox[checkBoxForMediaTypeText.length];

		for (int i = 0; i < checkBoxForMediaType.length; i++) {
			checkBoxForMediaType[i] = new JCheckBox(checkBoxForMediaTypeText[i]);
			nonAddMediaTypePanel.add(checkBoxForMediaType[i]);
			checkBoxForMediaType[i].addItemListener(checkBoxItemListener);
		}
		validate();
	}

	
	/*
	 * Makes the JPanel that will be displayed at the south region of contentPane border layout when user try to add an item.----HL
	 */
	public void makeSouthPanelOfAdd() {

		southForAddPanel = new JPanel();
		southForAddPanel.setBorder(BorderFactory
				.createTitledBorder("Save or Cancel"));
		southForAddPanel.setLayout(new FlowLayout());
		globalSouthPanelSaveButton = new JButton("Save");
		southForAddPanel.add(globalSouthPanelSaveButton);
		globalSouthPanelSaveButton.addActionListener(this);
		globalSouthPanelCancelButton = new JButton("Cancel");
		southForAddPanel.add(globalSouthPanelCancelButton);
		globalSouthPanelCancelButton.addActionListener(this);
		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the south region of contentPane border layout when user try to search.----HL
	 */
	public void makeSouthPanelOfSearch() {

		southForSearchPanel = new JPanel(new FlowLayout());
		globalSouthPanelSearchButton = new JButton("Search My Selection(s)");
		globalSouthPanelSearchButton.addActionListener(this);
		southForSearchPanel.add(globalSouthPanelSearchButton);

		validate();
	}

	/*
	 * Makes the JPanel that will be displayed at the south region of contentPane border layout when user try to 
	 * delete an item by typing in the index number of that item.----HL
	 */
	public void makeSouthPanelOfDelete() {

		southForDeletePanel = new JPanel(new FlowLayout());
		deleteResultPrompt = new JLabel(
				"Please type the index number of the entry to delete:");
		southForDeletePanel.add(deleteResultPrompt);
		deleteResultTextField = new JTextField();
		deleteResultTextField.setColumns(7);
		deleteResultTextField.addActionListener(this);
		southForDeletePanel.add(deleteResultTextField);

		globalSouthPanelDeleteButton = new JButton("Delete My Selection");
		globalSouthPanelDeleteButton.addActionListener(this);
		southForDeletePanel.add(globalSouthPanelDeleteButton);
	}

	/*
	 * Post all the JPanels needed/relevant to Adding an item.----HL
	 */
	public void postAddInterface() {

		globalCenterPanel.invalidate();
		globalWestPanel.invalidate();
		globalSouthPanel.invalidate();
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel,
				"BlankPanelCardAtCenter");
		contentPane.add(globalWestPanel, BorderLayout.WEST);
		cardLayoutAtGlobalWest.show(globalWestPanel,
				"AddMediaTypePanelAtWestCard");
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForAddCard");
		setAllTextFieldsEmpty();
		validate();
	}

	/*
	 * Post all the JPanels needed/relevant to Adding a book.----HL
	 */
	public void postAddBookInterface() {

		globalCenterPanel.invalidate();
		globalSouthPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.orange));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel, "AddBookCardAtCenter");
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForAddCard");
		setAllTextFieldsEmpty();
		validate();
	}

	/*
	 * Post all the JPanels needed/relevant to Adding a song.----HL
	 */
	public void postAddSongInterface() {

		globalCenterPanel.invalidate();
		globalCenterPanel
				.setBorder(new javax.swing.border.LineBorder(Color.red));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel, "AddSongCardAtCenter");
		globalSouthPanel.invalidate();
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForAddCard");
		setAllTextFieldsEmpty();
		validate();
	}

	/*
	 * Post all the JPanels needed/relevant to Adding a video.----HL
	 */
	public void postAddVideoInterface() {

		globalCenterPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.blue));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter
				.show(globalCenterPanel, "AddVideoCardAtCenter");
		globalSouthPanel.invalidate();
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForAddCard");
		setAllTextFieldsEmpty();
		validate();

	}

	/*
	 * Post all the JPanels needed/relevant to Adding a video game.----HL
	 */
	public void postAddVideoGameInterface() {

		globalCenterPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.yellow));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel,
				"AddVideoGameCardAtCenter");
		globalSouthPanel.invalidate();
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForAddCard");
		setAllTextFieldsEmpty();
		validate();
	}
	/*
	 * Post all the JPanels needed/relevant to search.----HL
	 */
	public void postSearchInterface() {

		globalCenterPanel.invalidate();
		globalWestPanel.invalidate();
		globalSouthPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.blue));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel, "SearchCardAtCenter");
		globalWestPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalWestPanel, BorderLayout.WEST);
		cardLayoutAtGlobalWest.show(globalWestPanel,
				"NonAddMediaTypePanelAtWestCard");
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.blue));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForSearchCard");
		setAllTextFieldsEmpty();
		validate();
	}

	/*
	 * Post all the JPanels needed/relevant to show search result.----HL
	 */
	public void postSearchResultInterface() {

		globalCenterPanel.invalidate();
		// globalSouthPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.orange));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel,
				"SearchResultCardAtCenter");
		setAllTextFieldsEmpty();
		validate();

	}

	/*
	 * Post all the JPanels needed/relevant to show search result for delete and entry.----HL
	 */
	public void postDeleteResultInterface() {

		globalCenterPanel.invalidate();
		// globalSouthPanel.invalidate();
		globalCenterPanel.setBorder(new javax.swing.border.LineBorder(
				Color.orange));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel,
				"DeleteResultCardAtCenter");
		setAllTextFieldsEmpty();
		validate();

	}

	/*
	 * Post all the JPanels needed/relevant to after user click "Delete" button.----HL
	 */
	public void postDeleteInterface() {

		globalCenterPanel.invalidate();
		globalWestPanel.invalidate();
		globalSouthPanel.invalidate();
		globalCenterPanel
				.setBorder(new javax.swing.border.LineBorder(Color.red));
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		cardLayoutAtGlobalCenter.show(globalCenterPanel, "DeleteCardAtCenter");
		globalWestPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
		contentPane.add(globalWestPanel, BorderLayout.WEST);
		cardLayoutAtGlobalWest.show(globalWestPanel,
				"NonAddMediaTypePanelAtWestCard");
		globalSouthPanel
				.setBorder(new javax.swing.border.LineBorder(Color.red));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		cardLayoutAtGlobalSouth.show(globalSouthPanel, "southForDeleteCard");
		setAllTextFieldsEmpty();
		validate();
	}

	/*
	 * Set all the text fields for adding book to empty String.----HL
	 */
	public void setBookTextFieldsEmpty() {
		formatTextFieldBook.setText("");
		titleTextFieldBook.setText("");
		locationTextFieldBook.setText("");
		noteTextFieldBook.setText("");
		authorTextField.setText("");
	}

	/*
	 * Set all the text fields for adding song to empty String.----HL
	 */
	public void setSongTextFieldsEmpty() {
		formatTextFieldSong.setText("");
		titleTextFieldSong.setText("");
		locationTextFieldSong.setText("");
		noteTextFieldSong.setText("");
		artistTextField.setText("");
		genreTextField.setText("");
	}

	/*
	 * Set all the text fields for adding video to empty String.----HL
	 */
	public void setVideoTextFieldsEmpty() {
		formatTextFieldVideo.setText("");
		titleTextFieldVideo.setText("");
		locationTextFieldVideo.setText("");
		noteTextFieldVideo.setText("");
		starTextField.setText("");
	}

	/*
	 * Set all the text fields for adding video game to empty String.----HL
	 */
	public void setVideoGameTextFieldsEmpty() {
		formatTextFieldVideoGame.setText("");
		titleTextFieldVideoGame.setText("");
		locationTextFieldVideoGame.setText("");
		noteTextFieldVideoGame.setText("");
	}

	/*
	 * Set all the text fields in the entire GUI to empty String.----HL
	 */
	public void setAllTextFieldsEmpty() {
		setBookTextFieldsEmpty();
		setSongTextFieldsEmpty();
		setVideoTextFieldsEmpty();
		setVideoGameTextFieldsEmpty();
		searchTitleTextField.setText("");
		deleteTitleTextField.setText("");
		deleteResultTextField.setText("");
	}

	/*
	 * Conducts the search user specified in search interface.----HL
	 */
	public void conductSearchMySelectionsInSearchInterface() {
		if (searchTitleTextField.getText().equals("")) {
			globalCenterPanel.invalidate();

			if (checkBoxForMediaType[0].isSelected()) {
				searchResultString = Controller
						.mediaTypeList(checkBoxForMediaType[0].getText());
			}

			if (checkBoxForMediaType[1].isSelected()) {
				searchResultString = searchResultString
						+ Controller.mediaTypeList(checkBoxForMediaType[1]
								.getText());
			}
			if (checkBoxForMediaType[2].isSelected()) {
				searchResultString = searchResultString
						+ Controller.mediaTypeList(checkBoxForMediaType[2]
								.getText());
			}
			if (checkBoxForMediaType[3].isSelected()) {
				searchResultString = searchResultString
						+ Controller.mediaTypeList(checkBoxForMediaType[3]
								.getText());
			}
			if (!checkBoxForMediaType[0].isSelected()
					&& !checkBoxForMediaType[1].isSelected()
					&& !checkBoxForMediaType[2].isSelected()
					&& !checkBoxForMediaType[3].isSelected()) {
				searchResultString = Controller.wholeList();
				JOptionPane
						.showMessageDialog(this,
								"Entire Library is displayed as no media type nor title is specified.");

			}

			searchResultTextArea = new JTextArea(searchResultString);
			searchScroll.setViewportView(searchResultTextArea);
			cardLayoutAtGlobalCenter.show(globalCenterPanel,
					"SearchResultCardAtCenter");
			contentPane.add(globalCenterPanel, BorderLayout.CENTER);
			globalCenterPanel.validate();
			validate();
		}

		// If user did put in title for search, do the following.----HL
		else if (!searchTitleTextField.getText().equals("")) {
			globalCenterPanel.invalidate();

			if (checkBoxForMediaType[0].isSelected()) {
				searchResultString = Controller.searchResult(
						checkBoxForMediaType[0].getText(),
						searchTitleTextField.getText());
			}

			if (checkBoxForMediaType[1].isSelected()) {
				searchResultString = searchResultString
						+ Controller.searchResult(
								checkBoxForMediaType[1].getText(),
								searchTitleTextField.getText());
			}
			if (checkBoxForMediaType[2].isSelected()) {
				searchResultString = searchResultString
						+ Controller.searchResult(
								checkBoxForMediaType[2].getText(),
								searchTitleTextField.getText());
			}

			if (checkBoxForMediaType[3].isSelected()) {
				searchResultString = searchResultString
						+ Controller.searchResult(
								checkBoxForMediaType[3].getText(),
								searchTitleTextField.getText());

			}

			if (!checkBoxForMediaType[0].isSelected()
					&& !checkBoxForMediaType[1].isSelected()
					&& !checkBoxForMediaType[2].isSelected()
					&& !checkBoxForMediaType[3].isSelected()
					&& !searchTitleTextField.getText().equals("")) {
				searchResultString = Controller.searchResult("", searchTitleTextField.getText());

				JOptionPane
						.showMessageDialog(
								this,
								"Entries of all media types with this title"
										+ " are displayed as you did not select any media type");
			}

			searchResultTextArea = new JTextArea(searchResultString);
			searchScroll.setViewportView(searchResultTextArea);
			cardLayoutAtGlobalCenter.show(globalCenterPanel,
					"SearchResultCardAtCenter");
			contentPane.add(globalCenterPanel, BorderLayout.CENTER);
			globalCenterPanel.validate();
			validate();

		}

		searchResultString = "";
		searchResultTextArea = new JTextArea("");
		setAllTextFieldsEmpty();
		for (int i = 0; i < checkBoxForMediaType.length; i++) {
			checkBoxForMediaType[i].setSelected(false);
			checkBoxForMediaType[i].addItemListener(checkBoxItemListener);
		}

		searchResultPanelAtCenter.validate();
		globalCenterPanel.validate();

	}

	private String deleteResultString;
	/*
	 * Conducts the search user specified in delete interface.----HL
	 */
	public void conductSearchMySelectionsInDeleteInterface() {

		globalCenterPanel.invalidate();

		if (deleteTitleTextField.getText().equals("")) {
			if (checkBoxForMediaType[0].isSelected()) {
				deleteResultString = Controller.searchResult(
						checkBoxForMediaType[0].getText(), "");
			}
			if (checkBoxForMediaType[1].isSelected()) {
				deleteResultString = deleteResultString
						+ Controller.searchResult(
								checkBoxForMediaType[1].getText(), "");
			}
			if (checkBoxForMediaType[2].isSelected()) {
				deleteResultString = deleteResultString
						+ Controller.searchResult(
								checkBoxForMediaType[2].getText(), "");
			}
			if (checkBoxForMediaType[3].isSelected()) {
				deleteResultString = deleteResultString
						+ Controller.searchResult(
								checkBoxForMediaType[3].getText(), "");
			}
			if (!checkBoxForMediaType[0].isSelected()
					& !checkBoxForMediaType[1].isSelected()
					& !checkBoxForMediaType[2].isSelected()
					& !checkBoxForMediaType[3].isSelected()) {
				deleteResultString = Controller.searchResult("", "");
				JOptionPane
						.showMessageDialog(
								this,
								"All Entries in the library"
										+ " are displayed as neither title nor media type is specified.");
			}
		}

		// If user did put in title for delete, do the following.----HL
		else if (!deleteTitleTextField.getText().equals("")) {

			boolean allCheckBoxesSelected = checkBoxForMediaType[0]
					.isSelected()
					& checkBoxForMediaType[1].isSelected()
					& checkBoxForMediaType[2].isSelected()
					& checkBoxForMediaType[3].isSelected();

			boolean allCheckBoxesNotSelected = !checkBoxForMediaType[0]
					.isSelected()
					& !checkBoxForMediaType[1].isSelected()
					& !checkBoxForMediaType[2].isSelected()
					& !checkBoxForMediaType[3].isSelected();

			if ((allCheckBoxesSelected || allCheckBoxesNotSelected)) {
				deleteResultString = Controller.searchResult("", deleteTitleTextField.getText());
				JOptionPane
						.showMessageDialog(
								this,
								"All media types with this title are"
										+ " displayed as you either selected or deselected all the media types.");
			}

			else {

				if (checkBoxForMediaType[0].isSelected()) {
					deleteResultString = Controller.searchResult(
							checkBoxForMediaType[0].getText(),
							deleteTitleTextField.getText());
				}
				if (checkBoxForMediaType[1].isSelected()) {
					deleteResultString = deleteResultString
							+ Controller.searchResult(
									checkBoxForMediaType[1].getText(),
									deleteTitleTextField.getText());
				}
				if (checkBoxForMediaType[2].isSelected()) {
					deleteResultString = deleteResultString
							+ Controller.searchResult(
									checkBoxForMediaType[2].getText(),
									deleteTitleTextField.getText());
				}

				if (checkBoxForMediaType[3].isSelected()) {
					deleteResultString = deleteResultString
							+ Controller.searchResult(
									checkBoxForMediaType[3].getText(),
									deleteTitleTextField.getText());
				}
			}
		}

		deleteResultTextArea = new JTextArea(deleteResultString);
		deleteScroll.setViewportView(deleteResultTextArea);
		cardLayoutAtGlobalCenter.show(globalCenterPanel,
				"DeleteResultCardAtCenter");
		contentPane.add(globalCenterPanel, BorderLayout.CENTER);
		globalCenterPanel.validate();
		deleteResultString = "";
		deleteResultTextArea = new JTextArea("");
		setAllTextFieldsEmpty();

		for (int i = 0; i < checkBoxForMediaType.length; i++) {
			checkBoxForMediaType[i].setSelected(false);
		}

		validate();
	}
	
	/*
	 * actionPerformed method responsible for the entire GUI.----HL
	 */
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == globalNorthPanelAddButton) {
			setAllTextFieldsEmpty();
			postAddInterface();
		}

		else if (evt.getSource() == globalNorthPanelSearchButton) {
			setAllTextFieldsEmpty();
			postSearchInterface();
		}

		else if (evt.getSource() == globalNorthPanelPrintButton) {

			globalCenterPanel.invalidate();
			globalWestPanel.invalidate();

			contentPane.add(globalWestPanel, BorderLayout.WEST);
			cardLayoutAtGlobalWest
					.show(globalWestPanel, "BlankPanelAtWestCard");

			contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
			cardLayoutAtGlobalSouth.show(globalSouthPanel,
					"BlankPanelCardAtSouth");

			printResultTextArea = new JTextArea(Controller.wholeList());
			printScroll.setViewportView(printResultTextArea);

			cardLayoutAtGlobalCenter.show(globalCenterPanel,
					"PrintResultCardAtCenter");
			contentPane.add(globalCenterPanel, BorderLayout.CENTER);

			setAllTextFieldsEmpty();
			globalCenterPanel.validate();
			globalWestPanel.validate();
			globalSouthPanel.validate();
		}

		else if (evt.getSource() == globalNorthPanelDeleteButton) {
			setAllTextFieldsEmpty();
			postDeleteInterface();
		}

		else if (evt.getSource() == globalNorthPanelQuitButton) {
			Controller.save(); // simple save -DM
			System.exit(0);
		}

		else if (evt.getSource() == globalSouthPanelSaveButton) {
			if (titleTextFieldBook.getText().equals("")
					& titleTextFieldSong.getText().equals("")
					& titleTextFieldVideo.getText().equals("")
					& titleTextFieldVideoGame.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						" Can't save this item. Title is required !");
			} else {
				switch (selectedRadioBtnTextInAdd) {

				case "Book":
					Controller.addBookEntry(formatTextFieldBook.getText(),
							titleTextFieldBook.getText(),
							locationTextFieldBook.getText(),
							noteTextFieldBook.getText(),
							authorTextField.getText());
					setBookTextFieldsEmpty();
					break;

				case "Song":
					Controller
							.addSongEntry(formatTextFieldSong.getText(),
									titleTextFieldSong.getText(),
									locationTextFieldSong.getText(),
									noteTextFieldSong.getText(),
									artistTextField.getText(),
									genreTextField.getText());
					setSongTextFieldsEmpty();
					break;

				case "Video":
					Controller.addVideoEntry(formatTextFieldVideo.getText(),
							titleTextFieldVideo.getText(),
							locationTextFieldVideo.getText(),
							noteTextFieldVideo.getText(),
							starTextField.getText());
					setVideoTextFieldsEmpty();
					break;

				case "Video Game":
					Controller.addVideoGameEntry(
							formatTextFieldVideoGame.getText(),
							titleTextFieldVideoGame.getText(),
							locationTextFieldVideoGame.getText(),
							noteTextFieldVideoGame.getText());
					setVideoGameTextFieldsEmpty();
					break;

				}
				globalCenterPanel.invalidate();
				globalWestPanel.invalidate();
				globalSouthPanel.invalidate();

				contentPane.add(globalCenterPanel, BorderLayout.CENTER);
				cardLayoutAtGlobalCenter.show(globalCenterPanel,
						"BlankPanelCardAtCenter");

				contentPane.add(globalWestPanel, BorderLayout.WEST);
				cardLayoutAtGlobalWest.show(globalWestPanel,
						"AddMediaTypePanelAtWestCard");

				contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
				cardLayoutAtGlobalSouth.show(globalSouthPanel,
						"BlankPanelCardAtSouth");

				setAllTextFieldsEmpty();
				validate();
				JOptionPane.showMessageDialog(this, "           "
						+ selectedRadioBtnTextInAdd + "   Saved !");
			}
		} else if (evt.getSource() == globalSouthPanelCancelButton) {
			setAllTextFieldsEmpty();
			JOptionPane.showMessageDialog(this, "   Entry  Cancelled !");
		} else if (evt.getSource() == globalSouthPanelSearchButton) {
			conductSearchMySelectionsInSearchInterface();
			setAllTextFieldsEmpty();
		} else if (evt.getSource() == globalSouthPanelSearchForDeleteButton) {
			conductSearchMySelectionsInDeleteInterface();
			setAllTextFieldsEmpty();
		} else if (evt.getSource() == globalSouthPanelDeleteButton) {
			Controller.deleteEntry(Integer.parseInt(deleteResultTextField
					.getText()));
			JOptionPane.showMessageDialog(this, "         Entry   Deleted.");
			setAllTextFieldsEmpty();
		}
		validate();
	}

	private JRadioButton radioSource;
	private String selectedRadioBtnTextInAdd;

	/*
	 * itemStateChanged method listens to item events of radio buttons only.----HL
	 */
	public void itemStateChanged(ItemEvent evt) {

		radioSource = (JRadioButton) evt.getSource();
		selectedRadioBtnTextInAdd = radioSource.getText();

		switch (selectedRadioBtnTextInAdd) {

		case "Book":
			postAddBookInterface();
			break;
		case "Song":
			postAddSongInterface();
			break;
		case "Video":
			postAddVideoInterface();
			break;
		case "Video Game":
			postAddVideoGameInterface();
			break;
		}
	}

	/*
	 * Item listener that listens to item events of all the JCheckBoxs only.----HL
	 */
	ItemListener checkBoxItemListener = new ItemListener() {

		public void itemStateChanged(ItemEvent evt) {
			if (evt.getStateChange() == ItemEvent.SELECTED) {
				if (evt.getItemSelectable() == checkBoxForMediaType[4]) {
					for (int i = 0; i < checkBoxForMediaType.length - 1; i++) {
						checkBoxForMediaType[i].setSelected(true);
					}
				}
			}
			if (evt.getStateChange() == ItemEvent.DESELECTED) {
				if (evt.getItemSelectable() == checkBoxForMediaType[4]) {
					for (int i = 0; i < checkBoxForMediaType.length - 1; i++) {
						checkBoxForMediaType[i].setSelected(false);
					}
				} else {
					for (int i = 0; i < checkBoxForMediaType.length - 1; i++) {
						checkBoxForMediaType[4].setSelected(false);
					}
				}
			}
		}
	};
}
