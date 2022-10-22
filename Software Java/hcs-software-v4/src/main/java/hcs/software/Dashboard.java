
package hcs.software;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import conexao.bd.DadosConexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author VAV02
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        URL caminhoIcone = getClass().getResource("/assets/hcs.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        
        initComponents();

        Looca looca = new Looca();
        Conversor conversor = new Conversor();

        informacoesSitesma(looca, conversor);
        informacoesCpu(looca, conversor);
        informacoesDisco(looca, conversor);
        informacoesRam(looca, conversor);

        Timer temporizador = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                consumoCpuRealTime(looca);
                consumoRamRealTime(looca);
                inserirDadosMedidas(looca, conversor);
                
            }
        };

        temporizador.schedule(task, 0, 1000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        lblSo = new javax.swing.JLabel();
        lblTempoAtv = new javax.swing.JLabel();
        lblArquitetura = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblNucleosFisicos = new javax.swing.JLabel();
        lblThreads = new javax.swing.JLabel();
        lblNucleosLogicos1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pgBarCpu = new javax.swing.JProgressBar();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblRamTotal = new javax.swing.JLabel();
        pgBarRam = new javax.swing.JProgressBar();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblRamDisp = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblRamUso = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pgBarDisco = new javax.swing.JProgressBar();
        lblDiscoTotal = new javax.swing.JLabel();
        lblDiscoUso = new javax.swing.JLabel();
        lblDiscoDisp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hardware Control System - Dashboard Sistema");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 100));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INFORMAÇÕES DO SISTEMA");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sistema Operacional:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fabricante:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Arquitetura:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tempo de Atividade:");

        lblFabricante.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblFabricante.setForeground(new java.awt.Color(255, 255, 102));

        lblSo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSo.setForeground(new java.awt.Color(255, 255, 102));

        lblTempoAtv.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTempoAtv.setForeground(new java.awt.Color(255, 255, 102));
        lblTempoAtv.setText("0 Days, 14:25:36");

        lblArquitetura.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblArquitetura.setForeground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(lblFabricante))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblArquitetura))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTempoAtv)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblSo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblFabricante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblArquitetura))
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempoAtv)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, -1));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0, 100));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INFORMAÇÕES DA CPU");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Núcleos");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Físicos:");

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(0, 244, 244));
        lblModelo.setText("Modelo");

        lblNucleosFisicos.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNucleosFisicos.setForeground(new java.awt.Color(0, 244, 244));
        lblNucleosFisicos.setText("0");

        lblThreads.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblThreads.setForeground(new java.awt.Color(0, 244, 244));
        lblThreads.setText("12");

        lblNucleosLogicos1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNucleosLogicos1.setForeground(new java.awt.Color(0, 244, 244));
        lblNucleosLogicos1.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Lógicos:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consumo CPU (%)");

        pgBarCpu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pgBarCpu.setForeground(new java.awt.Color(73, 167, 222));
        pgBarCpu.setStringPainted(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pgBarCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNucleosFisicos)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNucleosLogicos1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblThreads)))
                        .addGap(30, 30, 30)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgBarCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblNucleosLogicos1)
                    .addComponent(jLabel15)
                    .addComponent(lblNucleosFisicos)
                    .addComponent(jLabel4)
                    .addComponent(lblThreads))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblModelo)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 370, 270));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0, 100));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INFORMAÇÕES DA RAM");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Espaço Em Uso:");

        lblRamTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblRamTotal.setForeground(new java.awt.Color(112, 36, 181));
        lblRamTotal.setText("0");

        pgBarRam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pgBarRam.setForeground(new java.awt.Color(112, 36, 181));
        pgBarRam.setStringPainted(true);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Espaço Total:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Espaço Disponível:");

        lblRamDisp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblRamDisp.setForeground(new java.awt.Color(112, 36, 181));
        lblRamDisp.setText("0");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Consumo de Disco (%)");

        lblRamUso.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblRamUso.setForeground(new java.awt.Color(112, 36, 181));
        lblRamUso.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRamDisp))
                            .addComponent(jLabel23)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRamTotal))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRamUso))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pgBarRam, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgBarRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblRamTotal))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblRamUso))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblRamDisp))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, 270));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0, 100));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INFORMAÇÕES DO DISCO");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Espaço Em Uso:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Espaço Disponível:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Consumo de Disco (%)");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Espaço Total:");

        pgBarDisco.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pgBarDisco.setForeground(new java.awt.Color(0, 153, 0));
        pgBarDisco.setStringPainted(true);

        lblDiscoTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiscoTotal.setForeground(new java.awt.Color(51, 255, 51));
        lblDiscoTotal.setText("0");

        lblDiscoUso.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiscoUso.setForeground(new java.awt.Color(51, 255, 51));
        lblDiscoUso.setText("0");

        lblDiscoDisp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiscoDisp.setForeground(new java.awt.Color(51, 255, 51));
        lblDiscoDisp.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDiscoDisp))
                            .addComponent(jLabel16)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDiscoTotal))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDiscoUso))
                            .addComponent(pgBarDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgBarDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblDiscoTotal))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblDiscoUso))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblDiscoDisp))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 370, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/loginBackground3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    public void informacoesSitesma(Looca looca, Conversor conversor) {
        // Informações Sistema
        String sistemaOperacional, fabricanteSistema, arquiteturaSistema;

        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        fabricanteSistema = looca.getSistema().getFabricante();
        arquiteturaSistema = String.format("%d Bits", looca.getSistema().getArquitetura());

        lblSo.setText(sistemaOperacional);
        lblFabricante.setText(fabricanteSistema);
        lblArquitetura.setText(arquiteturaSistema);
        
        String tempoAtvSistema = conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
        lblTempoAtv.setText(tempoAtvSistema);
    }

    public void informacoesCpu(Looca looca, Conversor conversor) {
        // Informações CPU
        String modeloCpu = looca.getProcessador().getNome();
        Integer qtdNucleosFisicos, qtdNucleosLogicos, qtdTotalNucleos;

        qtdNucleosFisicos = looca.getProcessador().getNumeroCpusFisicas();
        qtdNucleosLogicos = looca.getProcessador().getNumeroCpusLogicas();
        qtdTotalNucleos = looca.getProcessador().getNumeroCpusFisicas() + looca.getProcessador().getNumeroCpusLogicas();

        lblModelo.setText(modeloCpu);
        lblNucleosFisicos.setText(qtdNucleosFisicos.toString());
        lblNucleosLogicos1.setText(qtdNucleosLogicos.toString());
        lblThreads.setText(qtdTotalNucleos.toString());
        

    }

    public void consumoCpuRealTime(Looca looca) {
        Double consumoCpu = looca.getProcessador().getUso();
        Long pgBarValueCpu = Math.round(consumoCpu);// Consumo de CPU Arredondado para inserir no setValue() da ProgressBar

        String strConsumoCpu = String.format("%.1f %%", consumoCpu);// String Consumo de CPU para inserir no setString() da ProgressBar

        pgBarCpu.setValue(pgBarValueCpu.intValue());
        pgBarCpu.setString(strConsumoCpu);
        pgBarCpu.setString(strConsumoCpu);

    }

    public void consumoRamRealTime(Looca looca) {
        Double consumoRam = (looca.getMemoria().getEmUso().doubleValue() * 100) / looca.getMemoria().getTotal(); // Consumo RAM %
        Long pgBarValueRam = Math.round(consumoRam);// Consumo de RAM Arredondado para inserir no setValue() da ProgressBar

        String strConsumoRam = String.format("%.1f %%", consumoRam);// String Consumo de RAM para inserir no setString() da ProgressBar
        pgBarRam.setValue(pgBarValueRam.intValue());
        pgBarRam.setString(strConsumoRam);
    }

    public void informacoesDisco(Looca looca, Conversor conversor) {
        // Informações DISCO
        Long espacoDiscoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal(); // Espaço Total do Disco
        Long espacoDiscoDisp = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel(); // Espaço Disponível do Disco
        Long espacoDiscoUso = espacoDiscoTotal - espacoDiscoDisp; // Espaço Usado do Disco

        String strDiscoTotalGb = conversor.formatarBytes(espacoDiscoTotal); // Espaço Total do Disco
        String strDiscoDispGb = conversor.formatarBytes(espacoDiscoDisp); // Espaço Disponível do Disco
        String strDiscoUsadoGb = conversor.formatarBytes(espacoDiscoUso); // Espaço Usado do Disco

        Double consumoDisco = (espacoDiscoUso.doubleValue() * 100) / espacoDiscoTotal.doubleValue(); // Consumo de Disco em %
        Long pgBarValueDisco = Math.round(consumoDisco); // Consumo de Disco Arredondado para inserir no setValue() da ProgressBar
        String strConsumoDisco = String.format("%.1f %%", consumoDisco); // String Consumo de Disco para inserir no setString() da ProgressBar

        lblDiscoTotal.setText(strDiscoTotalGb);
        lblDiscoUso.setText(strDiscoUsadoGb);
        lblDiscoDisp.setText(strDiscoDispGb);

        pgBarDisco.setValue(pgBarValueDisco.intValue());
        pgBarDisco.setString(strConsumoDisco);
    }

    public void informacoesRam(Looca looca, Conversor conversor) {
        // Informações RAM
        String strMemoriaTotalGb, strMemoriaUsoGb, strMemoriaDisponívelGb;

        strMemoriaTotalGb = conversor.formatarBytes(looca.getMemoria().getTotal()); // String Memória RAM Total Gb
        strMemoriaDisponívelGb = conversor.formatarBytes(looca.getMemoria().getDisponivel()); // String Memória Disponível Total Gb
        strMemoriaUsoGb = conversor.formatarBytes(looca.getMemoria().getEmUso()); // String Memória RAM Usada Gb

        lblRamTotal.setText(strMemoriaTotalGb);
        lblRamUso.setText(strMemoriaUsoGb);
        lblRamDisp.setText(strMemoriaDisponívelGb);

    }
    
    public void inserirDadosMedidas(Looca looca, Conversor conversor){
        
        DadosConexao database = new DadosConexao();

        JdbcTemplate connection = database.getConnection();
        
        // Inserindo consumo de CPU Carro Tesla Model S
        Double consumoCpu = looca.getProcessador().getUso();
        
        connection.update("insert into Medida(horario_registro,valor,fk_dispositivo) values (CURRENT_TIMESTAMP," + consumoCpu + ", 1);");
        
        // Inserindo consumo de RAM Carro Tesla Model S
        Double consumoRam = (looca.getMemoria().getEmUso().doubleValue() * 100) / looca.getMemoria().getTotal();;
        
        connection.update("insert into Medida(horario_registro,valor,fk_dispositivo) values (CURRENT_TIMESTAMP," + consumoRam + ", 3);");
    }
    
//    public void tempAtvRealTime(Looca looca, Conversor conversor) {
//        String tempoAtvSistema = conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
//        lblTempoAtv.setText(tempoAtvSistema);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblArquitetura;
    private javax.swing.JLabel lblDiscoDisp;
    private javax.swing.JLabel lblDiscoTotal;
    private javax.swing.JLabel lblDiscoUso;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNucleosFisicos;
    private javax.swing.JLabel lblNucleosLogicos1;
    private javax.swing.JLabel lblRamDisp;
    private javax.swing.JLabel lblRamTotal;
    private javax.swing.JLabel lblRamUso;
    private javax.swing.JLabel lblSo;
    private javax.swing.JLabel lblTempoAtv;
    private javax.swing.JLabel lblThreads;
    private javax.swing.JProgressBar pgBarCpu;
    private javax.swing.JProgressBar pgBarDisco;
    private javax.swing.JProgressBar pgBarRam;
    // End of variables declaration//GEN-END:variables
}
