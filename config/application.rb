require_relative 'boot'

require 'rails/all'

# Require the gems listed in Gemfile, including any gems
# you've limited to :test, :development, or :production.
Bundler.require(*Rails.groups)

module FlashSPR
  class Application < Rails::Application
    # Settings in config/environments/* take precedence over those specified here.
    # Application configuration should go into files in config/initializers
    # -- all .rb files in that directory are automatically loaded.

    #Web Console is activated in the dev environment. This is
    #usually a mistake. To ensure it's only activated in development
    #mode, move it to the development group of your Gemfile:

    #gem 'web-console', group: :development

    #If you still want to run it the dev environment (and know
    #what you are doing), put this in your Rails application
    #configuration:

    #config.web_console.development_only = false
    #config.web_console.development_only = false

  end
end


