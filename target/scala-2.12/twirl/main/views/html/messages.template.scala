
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
  def apply/*1.2*/(messages: Seq[Message], messageForm: Form[String], postUrl: Call)(implicit request: Request[AnyContent], messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""

"""),_display_(/*4.2*/main("MicroBot - messages")/*4.29*/ {_display_(Seq[Any](format.raw/*4.31*/("""

    """),format.raw/*6.5*/("""<section>


        <section class="msger">

            """),_display_(/*11.14*/for(msg <- messages) yield /*11.34*/ {_display_(Seq[Any](format.raw/*11.36*/("""
                """),format.raw/*12.17*/("""<div class="msg right-msg">
                    <div
                    class="msg-img"
                    style="background-image: url(https://image.flaticon.com/icons/svg/145/145867.svg)"
                    ></div>

                    <div class="msg-bubble">
                        <div class="msg-info">
                            <div class="msg-info-name">"""),_display_(/*20.57*/request/*20.64*/.session.data.getOrElse("username", "User")),format.raw/*20.107*/("""</div>
                        </div>

                        <div class="msg-text">
                        """),_display_(/*24.26*/msg/*24.29*/.message),format.raw/*24.37*/("""
                        """),format.raw/*25.25*/("""</div>
                    </div>
                </div>
                <div class="msg left-msg">
                    <div
                    class="msg-img"
                    style="background-image: url(https://image.flaticon.com/icons/svg/327/327779.svg)"
                    ></div>

                    <div class="msg-bubble">
                        <div class="msg-info">
                            <div class="msg-info-name">MiniBot</div>
                        </div>

                        <div class="msg-text">
                        """),_display_(/*40.26*/msg/*40.29*/.reply),format.raw/*40.35*/("""
                        """),format.raw/*41.25*/("""</div>
                    </div>
                </div>
            """)))}),format.raw/*44.14*/("""

        """),format.raw/*46.9*/("""</section>
    </section>
    <main  >
    """),_display_(/*49.6*/helper/*49.12*/.form(postUrl, 'id -> "user-login-form", 'class -> "form-group")/*49.76*/ {_display_(Seq[Any](format.raw/*49.78*/("""
        """),_display_(/*50.10*/helper/*50.16*/.CSRF.formField),format.raw/*50.31*/("""
        """),_display_(/*51.10*/helper/*51.16*/.inputText(
            messageForm("message"),
            'placeholder -> "message",
            'id -> "message",
            'class -> "form-control "
        )),format.raw/*56.10*/("""
        """),format.raw/*57.9*/("""<button class="btn btn-primary" style="width: 100vw">Send</button>
    """)))}),format.raw/*58.6*/("""
    """),format.raw/*59.5*/("""</main>


    </main>

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
                  DATE: 2020-03-18T21:05:51.150153
                  SOURCE: /home/lekan/Documents/workspace/personal_projects/MiniBot/app/views/messages.scala.html
                  HASH: 97fa73f6cb1a6ff62361826e82446dfe7adfa10e
                  MATRIX: 793->1|1028->143|1056->146|1091->173|1130->175|1162->181|1247->239|1283->259|1323->261|1368->278|1764->647|1780->654|1845->697|1983->808|1995->811|2024->819|2077->844|2662->1402|2674->1405|2701->1411|2754->1436|2855->1506|2892->1516|2962->1560|2977->1566|3050->1630|3090->1632|3127->1642|3142->1648|3178->1663|3215->1673|3230->1679|3415->1843|3451->1852|3553->1924|3585->1929
                  LINES: 21->1|26->2|28->4|28->4|28->4|30->6|35->11|35->11|35->11|36->12|44->20|44->20|44->20|48->24|48->24|48->24|49->25|64->40|64->40|64->40|65->41|68->44|70->46|73->49|73->49|73->49|73->49|74->50|74->50|74->50|75->51|75->51|80->56|81->57|82->58|83->59
                  -- GENERATED --
              */
          