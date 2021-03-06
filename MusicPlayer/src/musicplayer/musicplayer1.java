
package musicplayer;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class musicplayer1 extends JFrame 
{
        private AudioPlayer player = new AudioPlayer();
	private Thread playbackThread;
        
	private boolean isPlaying = false;
	private boolean isPause = false;
	
	private String audioFilePath;
	private String lastOpenPath;
    
        public musicplayer1() 
        {
        initComponents();
        getContentPane().setBackground(Color.getHSBColor(215, 158, 66));
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kunal's Music Player");
        setBackground(new java.awt.Color(103, 58, 183));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocation(new java.awt.Point(500, 260));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 83, 80));
        jLabel1.setText("MUSIC PLAYER");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(103, 58, 183));
        jButton1.setText("Open");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(233, 30, 99));
        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(2, 136, 209));
        jButton3.setText("Pause");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     openFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
				if (!isPlaying) 
				{
					playBack();
				} 
				else 
				{
					stopPlaying();
				}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (!isPause) 
				{
					pausePlaying();
				}
				else 
				{
					resumePlaying();
				}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void openFile() 
	{
		JFileChooser fileChooser = null;	
		if (lastOpenPath != null) 
		{
			fileChooser = new JFileChooser(lastOpenPath);
		} 
		else 
		{
			fileChooser = new JFileChooser();
		}
		FileFilter wavFilter = new FileFilter() 
		{
			@Override
			public String getDescription() 
			{
				return "Sound file (*.WAV)";
			}

			@Override
			public boolean accept(File file) 
			{
				if (file.isDirectory()) 
				{
					return true;
				} 
				else 
				{
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};
		fileChooser.setFileFilter(wavFilter);
		fileChooser.setDialogTitle("Open Audio File");

		int userChoice = fileChooser.showOpenDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) 
		{
			audioFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			lastOpenPath = fileChooser.getSelectedFile().getParent();
			if (isPlaying || isPause) 
			{
				stopPlaying();
				while (player.getAudioClip().isRunning()) 
				{
					try 
					{
						Thread.sleep(100);
					} 
					catch (InterruptedException ex) 
					{
						ex.printStackTrace();
					}
				}
			}
			playBack();
		}
	}
    private void playBack() 
	{
		isPlaying = true;
		playbackThread = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					jButton2.setText("Stop");
					jButton2.setEnabled(true);
					
					jButton3.setText("Pause");
					jButton3.setEnabled(true);
					
					player.load(audioFilePath);
					
					player.play();
					
					resetControls();
				} 
				catch (UnsupportedAudioFileException ex) 
				{	
					resetControls();
					ex.printStackTrace();
				}
				catch (LineUnavailableException ex) 
				{	
					resetControls();
					ex.printStackTrace();
				} 
				catch (IOException ex) 
				{					
					resetControls();
					ex.printStackTrace();
				}

			}
		});
		playbackThread.start();
	}

	private void stopPlaying() 
	{
		isPause = false;
		jButton3.setText("Pause");
		jButton3.setEnabled(false);
		player.stop();
		playbackThread.interrupt();
	}
	
	private void pausePlaying() 
	{
		jButton3.setText("Resume");
		isPause = true;
		player.pause();
		playbackThread.interrupt();
	}
	
	private void resumePlaying() 
	{
		jButton3.setText("Pause");
		isPause = false;
		player.resume();
		
		playbackThread.interrupt();		
	}
	
	private void resetControls() 
	{
		jButton2.setText("Play");
                jButton3.setEnabled(false);		
		isPlaying = false;		
	}
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new musicplayer1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
