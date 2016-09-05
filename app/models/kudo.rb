class Kudo < ApplicationRecord
  belongs_to :staff



  def self.monthly_count(num_of_months)
    generate_kudo_count(num_of-months)
  end  

  private
  	def self.generate_kudo_count(num_of_months)
  	  count_each_month =[]	
  	  num_of_months.downto(1).each do |month|
  	  	count_each_month.push between?(first_of_month, end_of_month).count
  	  end
  	  count_each_month
  	end

  	def self.first_of_month(month)
  	  month.months.ago.beginning_of_month.strfttime('%F %T')
  	end

  	def self.end_of_month(month)
  	  month.months.ago.end_of_month.strfttime('%F %T')
  	end

end
