/*
 * MonitorFrame.java
 * Created by John Melton G0ORX
 * Created on 31-Dec-2009, 17:31:23
 */

/*
 * This code has been and reviewed modified.
 * John Tucker, N8MDP
 */

/*
 * Revsion History
 * 2/1/13: Updated the frame dimension to support 960x520
 * 
 * 1/20/13: Updated the "public void updateSamples()" function to now include:
 *          1. offset - adjustment factor to relocate the Filter block based
 *                      on the dspserver offset value.
 *          2. localOscOffset - This is the actual dspserver offset value in Hz
 * 
 * 
 */

package jmonitor;

public class MonitorFrame extends javax.swing.JFrame implements MonitorUpdateListener {

    /** Creates new form MonitorFrame */
    public MonitorFrame(Client client) {
        this.client=client;
        initComponents();

        this.setTitle("JMonitor: "+client.getServer()+" Rx"+client.getReceiver()+" Rev:012013 for ghpsdr3-alex");
        monitorPanel.setClient(client);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitorPanel = new jmonitor.MonitorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JMonitor");
        setMinimumSize(new java.awt.Dimension(962, 260));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        monitorPanel.setMinimumSize(new java.awt.Dimension(960, 520));
        monitorPanel.setPreferredSize(new java.awt.Dimension(962, 520));
        getContentPane().add(monitorPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateSamples(float[] samples,int filterLow,int filterHigh,int sampleRate,int offset,int localOscOffset) {
        monitorPanel.updateSamples(samples,filterLow,filterHigh,sampleRate,offset,localOscOffset);
    }

    public void updateStatus() {
        monitorPanel.updateStatus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jmonitor.MonitorPanel monitorPanel;
    // End of variables declaration//GEN-END:variables

    private Client client;
}
