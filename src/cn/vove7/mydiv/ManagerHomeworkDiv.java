package cn.vove7.mydiv;


/**
 * Created by Vove on 2017/5/20.
 * 做作业管理块
 */
public class ManagerHomeworkDiv {
   private String hwId;
   private String title;
   private String body;
   private String buttonValue;


   public ManagerHomeworkDiv(String hwId, String title, String body, String buttonValue) {
      this.title = title;
      this.hwId = hwId;
      this.body = body;
      this.buttonValue = buttonValue;
   }

   public String toStuString() {
      return
              "        <div class=\"col-md-4\">\n" +
              "            <div class=\"panel\">\n" +
              "                <div class=\"panel-heading\">\n" +
              "                    <div class=\"page-title\">\n" +
              "                        " + title + "\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "                <div class=\"panel-body\">\n"
                      + body +
              "                </div>\n" +
              "                <div class=\"panel-buttonValue\">\n" +
              "                  <a href=doHomework.jsp?homeworkId="+hwId+ "&homeworkTitle="+title+" class='floatButton'>  " + buttonValue + "</a>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "        </div>\n";
   }
   public String toTeaString(){
      return
              " <div class=\"col-md-4\">\n" +
              "            <div class=\"panel\">\n" +
              "                <div class=\"panel-heading\">\n" +
              "                    <div class=\"page-title\">\n" +
              "                        " + title + "\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "                <div class=\"panel-body\">\n" +
              "\n" + body +
              "                </div>\n" +
              "                <div class=\"panel-buttonValue\">\n" +
                   (buttonValue.equals("重新编辑")?("<a href=Re-editHomework.jsp?homeworkId="+hwId+ " class='floatButton'>"+buttonValue+"</a>"):"")+
              "                  <a href=studentsHomeworkList.jsp?homeworkId="+hwId+ "&homeworkTitle="+title+" class='floatButton'> 批改作业</a>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "        </div>\n";
   }
}