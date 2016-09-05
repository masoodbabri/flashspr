class GruffGraphingService
  MONTHS_IN_YEAR = 12
  RESOLUTION_DPI = 400

  def initialize
  	@x_axis = {}
  	@monthly_index = 0
  end

  def create_chart
  	@kudos_chart = Gruff::Line.new(RESOLUTION_DPI)
  end

  def determine_title(title)
    @kudos_chart.title = title
  end

  def create_chart_details
  	generate_monthly_x_axis
  	@kudos_chart.labels = x_axis
  end

  def add_data_to_chart(instance, data)
  	@kudos_chart.data instance, data
  end

  def generate_chart(name_of_file)
  	@kudos_chart.write(name_of_file)
  end

  private

    attr_accessor :x_axis, :monthly_index, :kudos_chart
    
    def generate_monthly_x_axis
  	  MONTHS_IN_YEAR.downto(1).each do |month|
  	  	x_axis[monthly_index] = get_name_of_month(month)
        increment_monthly_index
  	  end
    end

    def get_name_of_month(month)
  	  month.months.ago.strftime("%b %y")
    end

    def increment_monthly_index
      @monthly_index+= 1
    end
end