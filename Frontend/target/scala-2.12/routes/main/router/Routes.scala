// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/seangrady/Desktop/CS4345/CS4345SemesterProject/Frontend/conf/routes
// @DATE:Mon Feb 20 19:45:38 CST 2023

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:15
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:15
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.HomeController.loginHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.HomeController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.HomeController.signupHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_loginHandler1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_HomeController_loginHandler1_invoker = createInvoker(
    HomeController_1.loginHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loginHandler",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_signup2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_HomeController_signup2_invoker = createInvoker(
    HomeController_1.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signup",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_signupHandler3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_HomeController_signupHandler3_invoker = createInvoker(
    HomeController_1.signupHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signupHandler",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index())
      }
  
    // @LINE:8
    case controllers_HomeController_loginHandler1_route(params@_) =>
      call { 
        controllers_HomeController_loginHandler1_invoker.call(HomeController_1.loginHandler())
      }
  
    // @LINE:10
    case controllers_HomeController_signup2_route(params@_) =>
      call { 
        controllers_HomeController_signup2_invoker.call(HomeController_1.signup())
      }
  
    // @LINE:12
    case controllers_HomeController_signupHandler3_route(params@_) =>
      call { 
        controllers_HomeController_signupHandler3_invoker.call(HomeController_1.signupHandler())
      }
  
    // @LINE:15
    case controllers_Assets_at4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(Assets_0.at(path, file))
      }
  }
}
