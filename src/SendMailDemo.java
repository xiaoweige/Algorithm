/**
 * @author dream
 */
public  class SendMailDemo {

        public static void main(String[] args) {
            // 您要发送给谁，标题，内容

            SendmailUtil.send("*****@qq.com", "标题", "内容", "smtp", "smtp.qq.com", "发送人名", "端口号", "用户名", "密码");
        }
}
