
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object messages extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Seq[Message],Form[String],Call,Request[AnyContent],MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: Seq[Message], messageForm: Form[String], postUrl: Call)( implicit request: Request[AnyContent], messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""

"""),_display_(/*4.2*/main("MicroBot - messages")/*4.29*/{_display_(Seq[Any](format.raw/*4.30*/("""

    """),format.raw/*6.5*/("""<body>

        <h4>Welcome to MiniMicroBot """),_display_(/*8.38*/request/*8.45*/.session.data.getOrElse("username", "")),format.raw/*8.84*/(""", pardon the username, if you will... Enter a text and let the bot respond like a boss</h4>


        """),_display_(/*11.10*/helper/*11.16*/.form(postUrl, 'id -> "user-login-form")/*11.56*/ {_display_(Seq[Any](format.raw/*11.58*/("""
            """),_display_(/*12.14*/helper/*12.20*/.CSRF.formField),format.raw/*12.35*/("""
            """),_display_(/*13.14*/helper/*13.20*/.inputText(
                messageForm("message"),
                '_label -> "Message",
                'placeholder -> "message",
                'id -> "message",
            )),format.raw/*18.14*/("""

            """),format.raw/*20.13*/("""<button>Send</button>
        """)))}),format.raw/*21.10*/("""



        """),format.raw/*25.9*/("""<div class="chat ">
            <h6>Chat History: </h6>
            <div id="message-group">
                """),_display_(/*28.18*/for(msg <- messages) yield /*28.38*/{_display_(Seq[Any](format.raw/*28.39*/("""
                    """),format.raw/*29.21*/("""<div class="message">
                        <div class="card" style="width: 300px; height: 50px; margin-bottom: 20px;">
                            <span class="card-header">User</span>
                            <div class=" card-body">
                                """),_display_(/*33.34*/msg/*33.37*/.message),format.raw/*33.45*/("""
"""),format.raw/*34.68*/("""
                            """),format.raw/*35.29*/("""</div>
                        </div>
                        <div class="bot-msg card" style="margin-bottom: 20px; width: 300px; height: 50px;">
                            <span class=" badge badge-dark">"""),_display_(/*38.62*/msg/*38.65*/.reply),format.raw/*38.71*/("""</span>
                        </div>
                    </div>
                """)))}),format.raw/*41.18*/("""
            """),format.raw/*42.13*/("""</div>

        </div>



        </body>
""")))}))
      }
    }
  }

  def render(messages:Seq[Message],messageForm:Form[String],postUrl:Call,request:Request[AnyContent],messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(messages,messageForm,postUrl)(request,messagesProvider)

  def f:((Seq[Message],Form[String],Call) => (Request[AnyContent],MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (messages,messageForm,postUrl) => (request,messagesProvider) => apply(messages,messageForm,postUrl)(request,messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-03-18T14:38:01.106893
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/messages.scala.html
                  HASH: 5f823605fdadb1975576e72834c07be3ddd24594
                  MATRIX: 793->1|1029->144|1057->147|1092->174|1130->175|1162->181|1233->226|1248->233|1307->272|1437->375|1452->381|1501->421|1541->423|1582->437|1597->443|1633->458|1674->472|1689->478|1890->658|1932->672|1994->703|2033->715|2170->825|2206->845|2245->846|2294->867|2595->1141|2607->1144|2636->1152|2665->1220|2722->1249|2956->1456|2968->1459|2995->1465|3109->1548|3150->1561
                  LINES: 21->1|26->2|28->4|28->4|28->4|30->6|32->8|32->8|32->8|35->11|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|42->18|44->20|45->21|49->25|52->28|52->28|52->28|53->29|57->33|57->33|57->33|58->34|59->35|62->38|62->38|62->38|65->41|66->42
                  -- GENERATED --
              */
          