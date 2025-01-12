package p12network;

import javax.swing.*;
import java.awt.*;

public class RegistrationAndLoginApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("회원가입 및 로그인");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // 창 크기를 늘림

        // 패널 생성
        JPanel pnlCenter = new JPanel(new CardLayout());
        JPanel pnlRegister = createRegisterPanel(pnlCenter);
        JPanel pnlLogin = createLoginPanel(pnlCenter);

        pnlCenter.add(pnlLogin, "Login");
        pnlCenter.add(pnlRegister, "Register");

        // 기본 로그인 화면 보이기
        CardLayout cl = (CardLayout) pnlCenter.getLayout();
        cl.show(pnlCenter, "Login");

        frame.add(pnlCenter);
        frame.setVisible(true);
    }

    private static JPanel createRegisterPanel(JPanel pnlCenter) {
        JPanel pnlRegister = new JPanel(new BorderLayout());
        pnlRegister.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // 여백 추가

        JPanel pnlNorth = new JPanel(new GridLayout(4, 2, 10, 10)); // 간격 추가
        JPanel pnlSouth = new JPanel(new FlowLayout());

        // 회원가입 입력 필드
        pnlNorth.add(new JLabel("ID:"));
        JTextField txtId = new JTextField();
        txtId.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtId);

        pnlNorth.add(new JLabel("Pass:"));
        JPasswordField txtPass = new JPasswordField();
        txtPass.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtPass);

        pnlNorth.add(new JLabel("Name:"));
        JTextField txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtName);

        pnlNorth.add(new JLabel("Mobile:"));
        JTextField txtMobile = new JTextField();
        txtMobile.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtMobile);

        pnlRegister.add(pnlNorth, BorderLayout.CENTER);

        // 버튼 추가
        JButton btnRegister = new JButton("가입");
        JButton btnCancel = new JButton("취소");
        pnlSouth.add(btnRegister);
        pnlSouth.add(btnCancel);
        pnlRegister.add(pnlSouth, BorderLayout.SOUTH);

        // 버튼 이벤트
        btnRegister.addActionListener(e -> {
            if (txtId.getText().trim().isEmpty() ||
                    new String(txtPass.getPassword()).trim().isEmpty() ||
                    txtName.getText().trim().isEmpty() ||
                    txtMobile.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(pnlRegister, "모든 필드를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(pnlRegister, "회원가입 성공!");
                CardLayout cl = (CardLayout) pnlCenter.getLayout();
                cl.show(pnlCenter, "Login");
            }
        });

        btnCancel.addActionListener(e -> {
            CardLayout cl = (CardLayout) pnlCenter.getLayout();
            cl.show(pnlCenter, "Login");
        });

        return pnlRegister;
    }

    private static JPanel createLoginPanel(JPanel pnlCenter) {
        JPanel pnlLogin = new JPanel(new BorderLayout());
        pnlLogin.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // 여백 추가

        JPanel pnlNorth = new JPanel(new GridLayout(2, 2, 10, 10)); // 간격 추가
        JPanel pnlSouth = new JPanel(new FlowLayout());

        // 로그인 입력 필드
        pnlNorth.add(new JLabel("ID:"));
        JTextField txtId = new JTextField();
        txtId.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtId);

        pnlNorth.add(new JLabel("Pass:"));
        JPasswordField txtPass = new JPasswordField();
        txtPass.setPreferredSize(new Dimension(200, 15)); // 텍스트 박스 크기 설정
        pnlNorth.add(txtPass);

        pnlLogin.add(pnlNorth, BorderLayout.CENTER);

        // 버튼 추가
        JButton btnLogin = new JButton("로그인");
        JButton btnRegister = new JButton("회원가입");
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnRegister);
        pnlLogin.add(pnlSouth, BorderLayout.SOUTH);

        // 버튼 이벤트
        btnLogin.addActionListener(e -> {
            if (txtId.getText().trim().isEmpty() ||
                    new String(txtPass.getPassword()).trim().isEmpty()) {
                JOptionPane.showMessageDialog(pnlLogin, "ID와 비밀번호를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(pnlLogin, "로그인 성공!");
            }
        });

        btnRegister.addActionListener(e -> {
            CardLayout cl = (CardLayout) pnlCenter.getLayout();
            cl.show(pnlCenter, "Register");
        });

        return pnlLogin;
    }
}
