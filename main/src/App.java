//Fahri Sahin 22120205001
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception{
        //kullanilcak nesnelerin tanimlanmasi 
        JFrame frame = new JFrame();
        JRadioButton r1 = new JRadioButton("Erkek");
        JRadioButton r2 = new JRadioButton("Kadin");
        JRadioButton r3 = new JRadioButton("Belirtmek istemiyorum");
        JLabel l1 = new JLabel("Ad Soyad");
        JLabel l2 = new JLabel("Telefon Numarasi");
        JLabel l3 = new JLabel("Email");
        JLabel l4 = new JLabel("Cinsiyet");
        JButton btn = new JButton("Kayit Et");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();

        //nesnelerin konumlarinin ayarlanmasi
        l1.setBounds(100, 100, 100, 70);
        l2.setBounds(100, 180, 150, 70);
        l3.setBounds(100, 260, 100, 70);
        l4.setBounds(100, 340, 100, 70);
        t1.setBounds(250, 110, 150, 50);
        t2.setBounds(250, 190, 150, 50);
        t3.setBounds(250, 270, 150, 50);
        r1.setBounds(220, 350, 100, 40);
        r2.setBounds(320, 350, 100, 40);
        r3.setBounds(420, 350, 200, 40);
        btn.setBounds(350, 500, 100, 70);

        //butona txt dosyalariyla ilgili islemlerin eklenmesi
        btn.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
             try {
                //yazilcak dosyanin olusturulmasi
                File file = new File("uyeler.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }

            //yazma islemi icin bWtriter acilmasi
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                String cinsiyet;
                //cinsiyetin icin eklencek yazinin checkboxlara baglı olarak secilmesi
                if(r1.isSelected()){
                    cinsiyet = "erkek";
                }
                if(r2.isSelected()){
                    cinsiyet = "kadin";
                }
                else{
                    cinsiyet ="Belirtmek istemeyen kullanici";
                }
                //yazinin eklenmesi
                bWriter.write(t1.getText()+"    "+ t2.getText()+"    "+ t3.getText()+"    " +cinsiyet);
                bWriter.newLine();
                //metinlerin ekleme sonrasi bosaltimasi
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                bWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            } 
             });  
 
        //componentlerin frame'e eklenmesi
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(btn);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);

        //framein gorsel ayarlari
        frame.setSize(800, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
